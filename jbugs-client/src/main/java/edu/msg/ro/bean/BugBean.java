package edu.msg.ro.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.common.exception.TechnicalExeption;

/****
 * Bug Bean.****
 * 
 * @author fulops
 *
 */

@ManagedBean
@SessionScoped
public class BugBean extends AbstractBean {

	@EJB
	BugFacade bugFacade;

	private BugDTO newBug = new BugDTO();

	private BugDTO selectedBug = new BugDTO();

	public BugDTO getNewBug() {
		return newBug;
	}

	public void setNewBug(BugDTO bug) {
		this.newBug = bug;
	}

	public BugDTO getSelectedBug() {
		return selectedBug;
	}

	public void setSelectedBug(BugDTO selectedBug) {
		this.selectedBug = selectedBug;
	}

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
		bugFacade.createBug(newBug);
		addMessage("Bug " + newBug.getTitle() + " created!");
		newBug = new BugDTO();
		return "bugs";
	}

	public String deleteBug(BugDTO bug) {
		try {
			bugFacade.deleteBug(bug);
			addMessage("Bugul " + newBug.getTitle() + " a fost sters!");
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
		return "bugs";
	}

	public String enterUpdateMode(BugDTO bug) {
		this.selectedBug = bug;
		return "bugs";
	}

	public String leaveUpdateMode() {
		selectedBug = new BugDTO();
		return "bugs";
	}

	public boolean verifyBugRendere(BugDTO bug) {
		return selectedBug != null && bug.getId().equals(selectedBug.getId());
	}

	public String editBug() throws TechnicalExeption {
		try {
			bugFacade.updateBug(selectedBug);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		selectedBug = new BugDTO();
		return "bugs";
	}

}
