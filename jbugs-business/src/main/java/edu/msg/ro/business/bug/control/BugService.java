package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.business.common.exception.BusinessException;
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

	public BugDTO createBug(BugDTO bugDTO) throws BusinessException, TechnicalExeption {

		Bug bugEntity = new Bug();
		bugDTOMapper.mapToEntity(bugDTO, bugEntity);
		bugDAO.persistEntity(bugEntity);
		Bug persistedBug = bugDAO.findEntity(bugEntity.getId());
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	public BugDTO updateBug(BugDTO bugDTO) throws TechnicalExeption {
		Bug persistedBug = bugDAO.getBug(bugDTO.getId());
		bugDTOMapper.mapToEntity(bugDTO, persistedBug);
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	public BugDTO deleteBug(BugDTO bugDTO) {
		Bug persistedBug = bugDAO.getBug(bugDTO.getId());
		return bugDTOMapper.mapToDTO(persistedBug);
	}

	public List<BugDTO> getAllBugs() {
		return bugDTOMapper.mapToDTOs(bugDAO.getAll());
	}

	public List<BugDTO> getAllSeverity() {
		return bugDTOMapper.mapToDTOs(bugDAO.getAllSeverity());
	}

}
