package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dao.BugRelationDAO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.bug.dto.mapper.BugRelationDTOMapper;
import edu.msg.ro.business.bug.enums.BugRelationEnum;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.persistence.bug.entity.BugRelation;

@Stateless
public class BugRelationService {

	@EJB
	private BugRelationDAO bugRelationDAO;

	@EJB
	private BugRelationDTOMapper bugRelationDTOMapper;

	@EJB
	private BugDAO bugDAO;

	public BugRelationDTO getBugRelation(Long id) throws TechnicalExeption {
		List<BugRelation> list = bugRelationDAO.getBugRelation(id);
		if (list.isEmpty()) {
			BugRelation ent = new BugRelation();
			ent.setBug1(bugDAO.findEntity(id));
			return bugRelationDTOMapper.mapToDTO(ent);
		} else if (list.size() == 1) {
			return bugRelationDTOMapper.mapToDTO(list.get(0));
		} else {
			throw new TechnicalExeption();
		}
	}

	public BugRelationDTO updateBugRelation(BugRelationDTO bugRelation) {
		boolean isNotInDb = bugRelation.getId() == null;
		BugRelation entity = null;
		if (isNotInDb) {
			entity = new BugRelation();
		} else {
			entity = bugRelationDAO.findEntity(bugRelation.getId());
		}
		bugRelationDTOMapper.mapToEntity(bugRelation, entity);
		if (isNotInDb && entity.getBug2() != null) {
			bugRelationDAO.persistEntity(entity);
		} else if (BugRelationEnum.NONE.equals(bugRelation.getRelation())) {
			bugRelationDAO.deleteEntity(entity);
			return null;
		}
		return bugRelationDTOMapper.mapToDTO(entity);
	}

}
