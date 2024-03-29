package edu.msg.ro.business.bug.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.bug.control.HistoryService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.HistoryDTO;
import edu.msg.ro.business.user.dto.UserDTO;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class HistoryFacade {

	@EJB
	private HistoryService historyService;

	public List<HistoryDTO> getAllHistory() {
		return historyService.getAllHistory();
	}

	public List<HistoryDTO> getHistory(UserDTO modifier, BugDTO bug) {
		return historyService.getHistory(modifier, bug);
	}

}
