package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.business.bug.enums.BugSeverity;
import edu.msg.ro.business.bug.enums.StatusEnum;
import edu.msg.ro.business.bug.interceptor.HistoryInterceptor;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * Controller for Bug component.
 * 
 * @author balinc
 *
 */
@Stateless
public class BugService {

	@EJB
	private BugDAO bugDAO;

	@EJB
	private BugDTOMapper bugDTOMapper;

	/**
	 * Method for creating new {@link Bug}.
	 * 
	 * @param bugDTO
	 * @return
	 */
	public BugDTO createBug(BugDTO bugDTO) {

		Bug bugEntity = new Bug();
		bugDTOMapper.mapToEntity(bugDTO, bugEntity);
		bugDAO.persistEntity(bugEntity);
		Bug persistedBug = bugDAO.findEntity(bugEntity.getId());
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	/**
	 * Method for updating an {@link Bug}.
	 * 
	 * @param bugDTO
	 * @return
	 * @throws TechnicalExeption
	 */
	@Interceptors({ HistoryInterceptor.class })
	public BugDTO updateBug(BugDTO bugDTO) {
		Bug persistedBug = bugDAO.getBug(bugDTO.getId());
		bugDTOMapper.mapToEntity(bugDTO, persistedBug);
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	/**
	 * Method for deteting an {@link Bug}.
	 * 
	 * @param bugDTO
	 * @return
	 */
	public BugDTO deleteBug(BugDTO bugDTO) {
		Bug persistedBug = bugDAO.getBug(bugDTO.getId());
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	/**
	 * Method for getting back all {@link Bug}s.
	 * 
	 * @return
	 */
	public List<BugDTO> getAllBugs() {
		return bugDTOMapper.mapToDTOs(bugDAO.getAll());
	}

	/**
	 * Method for deleting Bug attachemnt.
	 * 
	 * @param bugDTO
	 * @return
	 */
	public void deleteAttachment(Long id) {
		bugDAO.deleteAttachemtn(id);
	}

	public BugDTO findBug(Long id) {
		return bugDTOMapper.mapToDTO(bugDAO.findEntity(id));
	}

	public int getStatisticsBug1Option(StatusEnum open) {
		return bugDAO.getStatisticsBug1Option(open.key);
	}

	public int getStatisticsBug2Option(BugSeverity critical) {
		return bugDAO.getStatisticsBug2Option(critical.key);
	}

	public List<BugDTO> getAllBugsByQuery(String query) {
		return bugDTOMapper.mapToDTOs(bugDAO.getAllBugsByQuery(query));
	}

	public Object getBugByTitle(String value) {
		return bugDTOMapper.mapToDTO(bugDAO.findBugByTitle(value));
	}

}
