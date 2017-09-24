package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalException;
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
	 * @throws BusinessException
	 * @throws TechnicalException
	 */
	public BugDTO createBug(BugDTO bugDTO) throws BusinessException, TechnicalException {

		Bug bugEntity = new Bug();
		bugDTOMapper.mapToEntity(bugDTO, bugEntity);
		bugDAO.persistEntity(bugEntity);
		Bug persistedBug = bugDAO.findEntity(bugEntity.getId());
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	/**
	 * Method for updateing an {@link Bug}.
	 * 
	 * @param bugDTO
	 * @return
	 * @throws TechnicalException
	 */
	public BugDTO updateBug(BugDTO bugDTO) throws TechnicalException {
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
		if (persistedBug.getId() != null) {
			persistedBug = null;
		}
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
	 * @throws TechnicalException
	 */
	public void deleteAttachment(Long id) throws TechnicalException {
		bugDAO.deleteAttachemtn(id);
	}

}
