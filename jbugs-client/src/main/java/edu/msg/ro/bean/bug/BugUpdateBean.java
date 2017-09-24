package edu.msg.ro.bean.bug;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.util.StatusEnum;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.security.PermissionChecker;
import edu.msg.ro.business.user.security.PermissionEnum;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * Update {@link Bug} bean.
 * 
 * @author balinc
 *
 */
@ManagedBean
@ViewScoped
public class BugUpdateBean extends AbstractBugBean {

	@EJB
	private PermissionChecker permissionChecker;

	private BugDTO selectedBug = new BugDTO();

	/**
	 * Get for selectedBug.
	 * 
	 * @return
	 */
	public BugDTO getSelectedBug() {
		return selectedBug;
	}

	/**
	 * Set for selectedBug.
	 * 
	 * @param selectedBug
	 */
	public void setSelectedBug(BugDTO selectedBug) {
		this.selectedBug = selectedBug;
	}

	/**
	 * Method for gett all {@link BugStatus}.
	 * 
	 * @return
	 */
	public ArrayList<StatusEnum> getStatusList() {
		ArrayList<StatusEnum> response = new ArrayList<StatusEnum>();
		if (selectedBug.getId() == null) {
			return response;
		}
		StatusEnum selected = getSelectedBug().getStatus();
		response.add(selected);
		response.addAll(selected.neighbors);

		List<PermissionEnum> permissionList = new ArrayList<>();
		permissionList.add(PermissionEnum.BUG_CLOSE);

		UserDTO curentUser = null;
		String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("username");

		for (UserDTO userDTO : userFacade.getAllUsers()) {
			if (userDTO.getUsername().equals(username)) {
				curentUser = userDTO;
				break;
			}
		}

		if (!selectedBug.getStatus().equals(StatusEnum.CLOSE)
				&& !permissionChecker.canAccess(permissionList, curentUser)) {
			response.removeIf(e -> e.equals(StatusEnum.CLOSE));
		}

		return response;
	}

	/**
	 * Method for upload file to database.
	 * 
	 * @param event
	 */
	public void handleFileEdit(FileUploadEvent event) {

		byte[] file = new byte[event.getFile().getContents().length];
		System.arraycopy(event.getFile().getContents(), 0, file, 0, event.getFile().getContents().length);

		selectedBug.setAttachment(file);
		selectedBug.setAttachmentName(event.getFile().getFileName());
	}

	/**
	 * Delete attachment form database.
	 */
	public void deleteAttachment() {
		selectedBug.setAttachment(null);
		selectedBug.setAttachmentName(null);

	}

	/**
	 * Method for editing {@link Bug}.
	 * 
	 * @return
	 */
	public String editBug() {
		bugFacade.updateBug(selectedBug);
		addI18nMessage(I18N_BUG_SAVED, new Object[] { selectedBug.getTitle() });
		selectedBug = new BugDTO();
		return "bugManagment";
	}
}
