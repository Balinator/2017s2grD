package edu.msg.ro.business.bug.interceptor;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import edu.msg.ro.business.bug.control.BugService;
import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dao.HistoryDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.bug.entity.History;

@Stateless
public class HistoryInterceptor {

	@EJB
	private HistoryDAO historyDAO;

	@EJB
	private BugService bugService;

	@EJB
	private BugDAO bugDAO;

	@EJB
	private UserDAO userDAO;

	@AroundInvoke
	public Object modifyBugInterceptor(InvocationContext ctx) throws Exception {
		Object[] parameters = ctx.getParameters();
		BugDTO newBug = (BugDTO) parameters[0];

		BugDTO oldBug = bugService.findBug(newBug.getId());

		Object ret;
		try {
			ret = ctx.proceed();
		} catch (Exception e) {
			return null;
		}

		UserDTO curentUser = newBug.getModifier();

		Date date = new Date();

		for (Field field : oldBug.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object oldValue = field.get(oldBug);
			Object newValue = field.get(newBug);
			if (!field.getName().equals("modifier") && (oldValue == null && newValue != null)
					|| (oldValue != null && !oldValue.equals(newValue))) {
				System.out.println("history:" + oldValue + " != " + newValue);

				History history = new History();
				history.setAttribute(field.getName());
				history.setModified(bugDAO.findEntity(newBug.getId()));
				history.setModifier(userDAO.findEntity(curentUser.getId()));
				if (field.getName().equals("attachment")) {
					history.setNewValue(newValue != null ? hash((byte[]) newValue) : null);
					history.setOldValue(oldValue != null ? hash((byte[]) oldValue) : null);
				} else {
					history.setNewValue(newValue != null ? newValue.toString() : null);
					history.setOldValue(oldValue != null ? oldValue.toString() : null);
				}
				history.setModificationDate(date);

				historyDAO.persistEntity(history);
			}
		}

		return ret;
	}

	public String hash(byte[] value) {
		byte[] md_password;
		try {
			md_password = MessageDigest.getInstance("MD5").digest(value);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "Something went wrong";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < md_password.length; i++) {
			sb.append(Integer.toString((md_password[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
