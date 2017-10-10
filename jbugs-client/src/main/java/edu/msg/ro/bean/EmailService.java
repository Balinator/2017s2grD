package edu.msg.ro.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.msg.ro.business.bug.boundary.HistoryFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.HistoryDTO;
import edu.msg.ro.business.user.dto.UserDTO;

@Stateless
public class EmailService {

	@Resource(lookup = "emailSender")
	private Session session;

	@EJB
	private HistoryFacade historyFacade;

	@Asynchronous
	public void sendEmail(UserDTO modifier, BugDTO bug) {
		StringBuilder body = new StringBuilder();
		body.append("The bug \"");
		body.append(bug.getTitle());
		body.append("\" with the bugId ");
		body.append(bug.getId());
		body.append(" was modified.\nThe modifier was \"");
		body.append(modifier.getUsername());
		body.append("\" with the userId ");
		body.append(modifier.getId());
		body.append("\". To make contact with it use this email \"");
		body.append(modifier.getEmail());
		body.append("\" or this phonenumber \"");
		body.append(modifier.getPhoneNumber());
		body.append("\".\n\nModifications:\n");

		List<HistoryDTO> history = historyFacade.getHistory(modifier, bug);

		for (HistoryDTO h : history) {
			body.append(h.getAttribute());
			body.append(": \"");
			body.append(h.getOldValue());
			body.append("\" -> \"");
			body.append(h.getNewValue());
			body.append("\"\n");
		}

		body.append("\nFor futher questions contact an admin.");

		String title = "Bug updated";
		sendEmail(bug.getAuthor().getEmail(), title, body.toString(), session);
		if (bug.getAssigned() != null) {
			sendEmail(bug.getAssigned().getEmail(), title, body.toString(), session);
		}
	}

	private void sendEmail(String to, String subject, String body, Session session) {
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(session.getProperty("mail.from")));
			InternetAddress[] address = { new InternetAddress(to) };
			message.setRecipients(Message.RecipientType.TO, address);
			message.setSubject(subject);
			message.setSentDate(new Date());
			message.setText(body);
			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}
