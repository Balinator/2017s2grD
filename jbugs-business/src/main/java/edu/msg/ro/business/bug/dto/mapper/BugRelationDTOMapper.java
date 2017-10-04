package edu.msg.ro.business.bug.dto.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.bug.enums.BugRelationEnum;
import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.bug.entity.BugRelation;

@Stateless
public class BugRelationDTOMapper extends AbstractDTOMapper<BugRelation, BugRelationDTO> {

	@EJB
	private BugDTOMapper bugDTOMapper;

	@EJB
	private BugDAO bugDAO;

	@Override
	public BugRelationDTO getDTOInstance() {
		return new BugRelationDTO();
	}

	@Override
	protected void mapEntityToDTOFields(BugRelation entity, BugRelationDTO dto) {
		dto.setRelation(BugRelationEnum.values()[entity.getRelation()]);
		dto.setBug1(bugDTOMapper.mapToDTO(entity.getBug1()));
		dto.setBug2(bugDTOMapper.mapToDTO(entity.getBug2()));
	}

	@Override
	protected void mapDTOToEntityFields(BugRelationDTO dto, BugRelation entity) {
		entity.setRelation(dto.getRelation().getKey());
		Bug bug = bugDAO.getBug(dto.getBug1().getId());
		bugDTOMapper.mapToEntity(dto.getBug1(), bug);
		entity.setBug1(bug);
		if (dto.getBug2() != null) {
			bug = bugDAO.getBug(dto.getBug2().getId());
			bugDTOMapper.mapToEntity(dto.getBug2(), bug);
			entity.setBug2(bug);
		}
	}

}
