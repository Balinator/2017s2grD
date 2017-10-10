package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.HistoryDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.HistoryDTO;
import edu.msg.ro.business.bug.dto.mapper.HistoryDTOMapper;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.bug.entity.History;

@Stateless
public class HistoryService {

	@EJB
	private HistoryDAO historyDAO;

	@EJB
	private HistoryDTOMapper historyDTOMapper;

	public List<HistoryDTO> getAllHistory() {
		return historyDTOMapper.mapToDTOs(historyDAO.getAllHistory());
	}

	public List<HistoryDTO> getHistory(UserDTO modifier, BugDTO bug) {
		List<History> list = historyDAO.getHistory(modifier.getId(), bug.getId());
		for (int i = 0; i < list.size(); ++i) {
			History h = list.get(i);
			list.removeIf(e -> e.getAttribute().equals(h.getAttribute()) && e.getId() < h.getId());
		}
		return historyDTOMapper.mapToDTOs(list);
	}

}
