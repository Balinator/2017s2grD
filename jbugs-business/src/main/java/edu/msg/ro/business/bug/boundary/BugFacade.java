package edu.msg.ro.business.bug.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.bug.control.BugService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;

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

	public BugDTO createBug(BugDTO bug) throws BusinessException {
		return bugService.createBug(bug);
	}

	public BugDTO updateBug(BugDTO bug) throws BusinessException {
		return bugService.updateBug(bug);
	}

	public BugDTO deleteBug(BugDTO bugDTO) throws TechnicalExeption {
		return bugService.deleteBug(bugDTO);

	}

	public List<BugDTO> getAllbugs() {
		return bugService.getAllBugs();
	}
}
