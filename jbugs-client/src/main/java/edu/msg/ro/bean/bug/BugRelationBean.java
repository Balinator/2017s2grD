package edu.msg.ro.bean.bug;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.boundary.BugRelationFacade;
import edu.msg.ro.business.bug.boundary.CommentFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.bug.dto.CommentDTO;
import edu.msg.ro.business.bug.enums.BugRelationEnum;
import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
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

	@EJB
	private UserFacade userFacade;

	@EJB
	private CommentFacade commentFacade;

	private List<CommentDTO> allComments = new ArrayList<>();

	private String newMessage = "";

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
		getRefreshAllComments();
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

	public void getRefreshAllComments() {
		allComments = commentFacade.getAllCommentForBug(selectedBug);
	}

	public List<CommentDTO> getAllComments() {
		return allComments;
	}

	public void setAllComments(List<CommentDTO> allComments) {
		this.allComments = allComments;
	}

	public String getCommentDate(CommentDTO comment) {
		StringBuilder builder = new StringBuilder();
		builder.append(new SimpleDateFormat("dd/MM/yyyy").format(comment.getTargetDate()));
		return builder.toString();
	}

	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}

	public void makeComment() {
		if (newMessage.length() > 0) {
			CommentDTO comment = new CommentDTO();
			comment.setBug(bugFacade.findBug(selectedBug.getId()));
			comment.setCreator(userFacade.getUserByUsername(getLoggedUser().getUsername()));
			comment.setMessage(newMessage);
			comment.setTargetDate(new Date());

			commentFacade.createComment(comment);
			newMessage = "";

			getRefreshAllComments();
		}
	}
}
