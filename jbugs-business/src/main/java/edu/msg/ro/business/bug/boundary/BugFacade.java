package edu.msg.ro.business.bug.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.bug.control.BugService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.enums.BugSeverity;
import edu.msg.ro.business.bug.enums.StatusEnum;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * Boundary for bug component.
 *
 * @author balinc
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BugFacade {

	@EJB
	private BugService bugService;

	/**
	 * Method for creating new {@link Bug}.
	 * 
	 * @param bug
	 * @return
	 */
	public BugDTO createBug(BugDTO bug) {
		return bugService.createBug(bug);
	}

	/**
	 * Method for updating {@link Bug}.
	 * 
	 * @param bug
	 * @return
	 */
	public BugDTO updateBug(BugDTO bug) {
		return bugService.updateBug(bug);
	}

	/**
	 * Method for deleting {@link Bug}.
	 * 
	 * @param bugDTO
	 * @return
	 */
	public BugDTO deleteBug(BugDTO bugDTO) {
		return bugService.deleteBug(bugDTO);
	}

	/**
	 * Method for getting back all {@link Bug}s.
	 * 
	 * @return
	 */
	public List<BugDTO> getAllbugs() {
		return bugService.getAllBugs();
	}

	public BugDTO findBug(Long id) {
		return bugService.findBug(id);
	}

	public int getStatisticsBug1Option(StatusEnum open) {
		return bugService.getStatisticsBug1Option(open);
	}

	public int getStatisticsBug2Option(BugSeverity critical) {
		return bugService.getStatisticsBug2Option(critical);
	}

	public List<BugDTO> getAllBugsByQuery(String query) {
		return bugService.getAllBugsByQuery(query);
	}

	public Object getBugByTitle(String value) {
		return bugService.getBugByTitle(value);
	}
}
