package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.HistoryDAO;
import edu.msg.ro.business.bug.dto.HistoryDTO;
import edu.msg.ro.business.bug.dto.mapper.HistoryDTOMapper;

@Stateless
public class HistoryService {

	@EJB
	private HistoryDAO historyDAO;

	@EJB
	private HistoryDTOMapper historyDTOMapper;

	public List<HistoryDTO> getAllHistory() {
		return historyDTOMapper.mapToDTOs(historyDAO.getAllHistory());
	}

}
