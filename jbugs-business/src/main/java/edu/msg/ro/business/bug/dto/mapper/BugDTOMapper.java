package edu.msg.ro.business.bug.dto.mapper;

import javax.enterprise.context.Dependent;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.persistence.bug.entity.Bug;

@Dependent
public class BugDTOMapper extends AbstractDTOMapper<Bug, BugDTO> {

	@Override
	public BugDTO getDTOInstance() {
		return new BugDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Bug entity, BugDTO dto) {
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setAuthor(entity.getAuthor());
		dto.setAssigned(entity.getAssigned());
		dto.setAttachment(entity.getAttachment());
		dto.setFixedIn(entity.getFixedIn());
		dto.setSeverity(entity.getSeverity());
		dto.setStatus(entity.getStatus());
		dto.setTargetDate(entity.getTargetDate());
		dto.setVersion(entity.getVersion());
	}

	@Override
	protected void mapDTOToEntityFields(BugDTO dto, Bug entity) {
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setAuthor(dto.getAuthor());
		entity.setAssigned(dto.getAssigned());
		entity.setAttachment(dto.getAttachment());
		entity.setFixedIn(dto.getFixedIn());
		entity.setSeverity(dto.getSeverity());
		entity.setStatus(dto.getStatus());
		entity.setTargetDate(dto.getTargetDate());
		entity.setVersion(dto.getVersion());
	}
}
