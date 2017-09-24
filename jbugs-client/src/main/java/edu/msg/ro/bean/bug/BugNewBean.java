package edu.msg.ro.bean.bug;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.FileUploadEvent;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.util.StatusEnum;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * New {@link Bug} bean.
 * 
 * @author balinc
 */
@ManagedBean
@RequestScoped
public class BugNewBean extends AbstractBugBean {

	private BugDTO newBug = new BugDTO();

	private UserDTO assignedUser = new UserDTO();

	/**
	 * Get for newBug.
	 * 
	 * @return
	 */
	public BugDTO getNewBug() {
		return newBug;
	}

	/**
	 * Set for newBug.
	 * 
	 * @param bug
	 */
	public void setNewBug(BugDTO bug) {
		this.newBug = bug;
	}

	/**
	 * Get user to assign the {@link Bug}.
	 * 
	 * @return
	 */
	public UserDTO getAssignedUser() {
		return assignedUser;
	}

	/**
	 * Set user to assign the {@link Bug}.
	 * 
	 * @param user
	 */
	public void setAssignedUser(UserDTO user) {
		this.assignedUser = user;
	}

	/**
	 * Method for upload file to database
	 * 
	 * @param event
	 */
	public void handleFileUpload(FileUploadEvent event) {
		byte[] file = new byte[event.getFile().getContents().length];
		System.arraycopy(event.getFile().getContents(), 0, file, 0, event.getFile().getContents().length);

		newBug.setAttachment(file);
		newBug.setAttachmentName(event.getFile().getFileName());

	}

	/**
	 * Just create a bug without return.
	 */
	public String createNewBug() {
		newBug.setAssigned(assignedUser);
		newBug.setAuthor(getLoggedUser());
		newBug.setStatus(StatusEnum.OPEN);
		bugFacade.createBug(newBug);
		addI18nMessage(I18N_BUG_SAVED, new Object[] { newBug.getTitle() });
		newBug = new BugDTO();
		return "bugManagment";
	}
}
