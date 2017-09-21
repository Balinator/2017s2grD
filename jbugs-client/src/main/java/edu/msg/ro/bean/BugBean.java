package edu.msg.ro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.enums.BugSeverity;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.bug.entity.StatusEnum;

/****
 * Bug Bean.****
 * 
 * @author fulops
 *
 */

@ManagedBean
@ViewScoped
public class BugBean extends AbstractBean {

	@EJB
	BugFacade bugFacade;

	private BugDTO newBug = new BugDTO();

	private BugDTO selectedBug = new BugDTO();

	private List<BugDTO> buglist;

	private List<BugDTO> filteredBugList;

	private ArrayList<StatusEnum> selectedStatusList;

	private StatusEnum[] statusList;

	private int statuses;

	private BugSeverity[] severityList;

	private int severities;

	private UserDTO assignedUser = new UserDTO();

	private StreamedContent file;

	public UserDTO getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(UserDTO user) {
		this.assignedUser = user;
	}

	/**
	 * Init method.
	 */
	@PostConstruct
	public void init() {
		buglist = bugFacade.getAllbugs();
	}

	/**
	 * Method for getting all {@link Bug}s.
	 * 
	 * @return
	 */
	public List<BugDTO> getBugList() {
		return buglist;
	}

	/**
	 * Get for filteredBugList.
	 * 
	 * @return
	 */
	public List<BugDTO> getFilteredBugList() {
		return filteredBugList;
	}

	/**
	 * Set for filteredBugList.
	 * 
	 * @param filteredBugList
	 */
	public void setFilteredBugList(List<BugDTO> filteredBugList) {
		this.filteredBugList = filteredBugList;
	}

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
	 * + Method for getting back all {@link Bug}s.
	 * 
	 * @return
	 */
	public List<BugDTO> getAllBugs() {
		return bugFacade.getAllbugs();
	}

	/**
	 * Just create a bug without return.
	 * 
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	public String createNewBug() throws BusinessException, TechnicalExeption {
		newBug.setAssigned(assignedUser);
		newBug.setAuthor(assignedUser);// todo: change it
		bugFacade.createBug(newBug);
		// addMessage("Bug " + newBug.getTitle() + " created!");
		newBug = new BugDTO();
<<<<<<< HEAD
		return "bugs";
=======
		return "bugManagment";
>>>>>>> 2ef23f6584259f31d7e5e0988482955eee5c24e1
	}

	/**
	 * Method for verifying if needed to render element.
	 * 
	 * @param bug
	 * @return
	 */
	public boolean verifyBugRendere(BugDTO bug) {
		return selectedBug != null && bug.getId().equals(selectedBug.getId());
	}

	/**
	 * Method for editing {@link Bug}.
	 * 
	 * @return
	 * @throws TechnicalExeption
	 */
	public String editBug() throws TechnicalExeption {
		try {
			bugFacade.updateBug(selectedBug);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		selectedBug = new BugDTO();
		return "bugManagment";
	}

	// for bug filter
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

		return response;
	}

	/**
	 * Status Enum by ID
	 * 
	 * @param id
	 * @return
	 */
	public StatusEnum getEnumById(int id) {
		return StatusEnum.values()[id];
	}

	public StatusEnum[] getAllStatusList() {
		return StatusEnum.values();
	}

	public void setStatusList(StatusEnum[] statusList) {
		this.statusList = statusList;
	}

	/**
	 * Set for selectedStatusList.
	 * 
	 * @param selectedStatusList
	 */
	public void setStatusList(ArrayList<StatusEnum> selectedStatusList) {
		this.selectedStatusList = selectedStatusList;
	}

	/**
	 * Get for statuses.
	 * 
	 * @return
	 */
	public int getStatuses() {
		return statuses;
	}

	/**
	 * Set for statuses.
	 * 
	 * @param statuses
	 */
	public void setStatuses(int statuses) {
		this.statuses = statuses;
	}

	/**
	 * Method for get all {@link BugSeverity}.
	 * 
	 * @return
	 */
	public BugSeverity[] getSeverityList() {
		return BugSeverity.values();
	}

	/**
	 * Set for severityList.
	 * 
	 * @param severityList
	 */
	public void setSeverityList(BugSeverity[] severityList) {
		this.severityList = severityList;
	}

	/**
	 * Get for severities.
	 * 
	 * @return
	 */
	public int getSeverities() {
		return severities;
	}

	/**
	 * Set for severities.
	 * 
	 * @param severities
	 */
	public void setSeverities(int severities) {
		this.severities = severities;
	}

	/**
	 * Method for validation for creating a {@link Bug}.
	 * 
	 * @param context
	 * @param uic
	 * @param value
	 * @throws ValidationException
	 */
	public void validate(FacesContext context, UIComponent uic, Object value) throws ValidationException {

		String input = (String) value;

		if (input.length() == 0) {
			((UIInput) uic).setValid(false);
			FacesMessage message = new FacesMessage("Not valid data");// TODO:
																		// i18n
			context.addMessage(uic.getClientId(context), message);
		}
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

		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	/**
	 * Method for upload file to database
	 * 
	 * @param event
	 */

	//need to refactor --handleFileUplod
	public void handleFileEdit(FileUploadEvent event) {

		byte[] file = new byte[event.getFile().getContents().length];
		System.arraycopy(event.getFile().getContents(), 0, file, 0, event.getFile().getContents().length);

		selectedBug.setAttachment(file);

		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
