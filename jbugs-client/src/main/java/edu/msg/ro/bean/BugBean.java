package edu.msg.ro.bean;

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

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.enums.BugSeverity;
import edu.msg.ro.enums.BugStatus;
import edu.msg.ro.persistence.bug.entity.Bug;

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

	private BugStatus[] statusList;

	private int statuses;

	private BugSeverity[] severityList;

	private int severities;

	private UserDTO assignedUser = new UserDTO();

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
		return "bugs";
	}

	/**
	 * Method for deleting a {@link Bug}.
	 * 
	 * @param bug
	 * @return
	 */
	public String deleteBug(BugDTO bug) {
		bugFacade.deleteBug(bug);
		addMessage("Bugul " + newBug.getTitle() + " a fost sters!");

		return "bugs";
	}

	/**
	 * Method for entering update mode.
	 * 
	 * @param bug
	 * @return
	 */
	public String enterUpdateMode(BugDTO bug) {
		this.selectedBug = bug;
		return "bugs";
	}

	/**
	 * Method for leaving update mode.
	 * 
	 * @return
	 */
	public String leaveUpdateMode() {
		selectedBug = new BugDTO();
		return "bugs";
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
		return "bugs";
	}

	// for bug filter
	/**
	 * Method for gett all {@link BugStatus}.
	 * 
	 * @return
	 */
	public BugStatus[] getStatusList() {
		return BugStatus.values();
	}

	/**
	 * Set for statusList.
	 * 
	 * @param statusList
	 */
	public void setStatusList(BugStatus[] statusList) {
		this.statusList = statusList;
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
			FacesMessage message = new FacesMessage("Not valid data");
			context.addMessage(uic.getClientId(context), message);
		}
	}

}
