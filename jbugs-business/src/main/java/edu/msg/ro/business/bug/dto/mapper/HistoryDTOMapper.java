package edu.msg.ro.business.bug.dto.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.HistoryDTO;
import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.bug.entity.History;
import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class HistoryDTOMapper extends AbstractDTOMapper<History, HistoryDTO> {

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserDAO userDAO;

	@EJB
	private BugDTOMapper bugDTOMapper;

	@EJB
	private BugDAO bugDAO;

	@Override
	public HistoryDTO getDTOInstance() {
		return new HistoryDTO();
	}

	@Override
	protected void mapEntityToDTOFields(History entity, HistoryDTO dto) {
		dto.setAttribute(entity.getAttribute());
		dto.setModificationDate(entity.getModificationDate());
		dto.setModifier(userDTOMapper.mapToDTO(entity.getModifier()));
		dto.setNewValue(entity.getNewValue());
		dto.setOldValue(entity.getOldValue());
		dto.setModified(bugDTOMapper.mapToDTO(entity.getModified()));
	}

	@Override
	protected void mapDTOToEntityFields(HistoryDTO dto, History entity) {
		entity.setAttribute(dto.getAttribute());
		entity.setModificationDate(dto.getModificationDate());
		User user = userDAO.findEntity(dto.getModifier().getId());
		userDTOMapper.mapToEntity(dto.getModifier(), user);
		entity.setModifier(user);
		entity.setNewValue(dto.getNewValue());
		entity.setOldValue(dto.getOldValue());
		Bug bug = bugDAO.findEntity(dto.getModified().getId());
		bugDTOMapper.mapToEntity(dto.getModified(), bug);
		entity.setModified(bug);
	}

}
