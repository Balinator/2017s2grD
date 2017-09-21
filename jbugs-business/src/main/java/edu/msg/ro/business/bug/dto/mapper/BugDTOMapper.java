package edu.msg.ro.business.bug.dto.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * 
 * @author balinc
 *
 */
@Stateless
public class BugDTOMapper extends AbstractDTOMapper<Bug, BugDTO> {

	@EJB
	private UserDTOMapper userDtoMapper;

	@EJB
	private UserDAO userDAO;

	/**
	 * Method for instaciating {@link BugDTO}.
	 */
	@Override
	public BugDTO getDTOInstance() {
		return new BugDTO();
	}

	/**
	 * Method for filling {@link BugDTO}.
	 */
	@Override
	protected void mapEntityToDTOFields(Bug entity, BugDTO dto) {
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setAuthor(userDtoMapper.mapToDTO(entity.getAuthor()));
		dto.setAssigned(userDtoMapper.mapToDTO(entity.getAssigned()));
		dto.setAttachment(entity.getAttachment());
		dto.setFixedIn(entity.getFixedIn());
		dto.setSeverity(entity.getSeverity());
		dto.setStatus(entity.getStatus());
		dto.setTargetDate(entity.getTargetDate());
		dto.setVersion(entity.getVersion());
		dto.setAttachmentName(entity.getAttachmentName());
	}

	/**
	 * Method for filling {@link Bug}.
	 */
	@Override
	protected void mapDTOToEntityFields(BugDTO dto, Bug entity) {
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setAuthor(userDAO.findEntity(dto.getAuthor().getId()));
		entity.setAssigned(userDAO.findEntity(dto.getAssigned().getId()));
		entity.setAttachment(dto.getAttachment());
		entity.setFixedIn(dto.getFixedIn());
		entity.setSeverity(dto.getSeverity());
		entity.setStatus(dto.getStatus());
		entity.setTargetDate(dto.getTargetDate());
		entity.setVersion(dto.getVersion());
		entity.setAttachmentName(dto.getAttachmentName());
	}
}
