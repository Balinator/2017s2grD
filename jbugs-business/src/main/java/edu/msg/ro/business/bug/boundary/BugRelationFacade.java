package edu.msg.ro.business.bug.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.bug.control.BugRelationService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.common.exception.TechnicalExeption;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BugRelationFacade {

	@EJB
	private BugRelationService bugRelationService;

	public BugRelationDTO getBugRelation(BugDTO selectedBug) throws TechnicalExeption {
		return bugRelationService.getBugRelation(selectedBug.getId());
	}

	public BugRelationDTO updateBugRelation(BugRelationDTO bugRelation) {
		return bugRelationService.updateBugRelation(bugRelation);
	}

}
