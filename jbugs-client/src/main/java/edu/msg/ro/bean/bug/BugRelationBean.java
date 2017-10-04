package edu.msg.ro.bean.bug;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.boundary.BugRelationFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.bug.enums.BugRelationEnum;
import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * Update {@link Bug} bean.
 * 
 * @author balinc
 *
 */
@ManagedBean
@ViewScoped
public class BugRelationBean extends AbstractBugBean {

	private static final String I18N_BUG_RELATION_SAVED = "bug.relation.crud.save.success";

	@EJB
	private BugRelationFacade bugRelationFacade;

	@EJB
	private BugFacade bugFacade;

	private BugDTO selectedBug = new BugDTO();

	private BugRelationDTO bugRelation = new BugRelationDTO();

	public List<BugRelationEnum> getRelationList() {
		ArrayList<BugRelationEnum> relations = new ArrayList<>();

		for (BugRelationEnum bre : BugRelationEnum.values()) {
			relations.add(bre);
		}

		return relations;
	}

	public List<BugDTO> completeBug(String query) {
		List<BugDTO> bugs = bugFacade.getAllBugsByQuery(query);
		bugs.removeIf(b -> b.getId().equals(selectedBug.getId()));
		return bugs;
	}

	public boolean required() {
		return !BugRelationEnum.NONE.equals(bugRelation.getRelation()) || bugRelation.getRelation() != null;
	}

	public boolean disabled() {
		return BugRelationEnum.NONE.equals(bugRelation.getRelation()) || bugRelation.getRelation() == null;
	}

	public String editRelation() {
		bugRelationFacade.updateBugRelation(bugRelation);

		addI18nMessage(I18N_BUG_RELATION_SAVED, new Object[] { selectedBug.getTitle() });

		selectedBug = new BugDTO();
		bugRelation = new BugRelationDTO();
		return "bugManagment";
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
		try {
			setBugRelation(bugRelationFacade.getBugRelation(selectedBug));
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
	}

	public void chack() {
		if (BugRelationEnum.NONE.equals(bugRelation.getRelation())) {
			bugRelation.setBug2(null);
		}
	}

	public BugRelationDTO getBugRelation() {
		return bugRelation;
	}

	public void setBugRelation(BugRelationDTO bugRelation) {
		this.bugRelation = bugRelation;
	}
}
