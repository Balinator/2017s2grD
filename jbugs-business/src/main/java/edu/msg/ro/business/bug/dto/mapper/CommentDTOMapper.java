package edu.msg.ro.business.bug.dto.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.CommentDTO;
import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.bug.entity.Comment;
import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class CommentDTOMapper extends AbstractDTOMapper<Comment, CommentDTO> {

	@EJB
	private BugDTOMapper bugDTOMapper;

	@EJB
	private BugDAO bugDAO;

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserDAO userDAO;

	@Override
	public CommentDTO getDTOInstance() {
		return new CommentDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Comment entity, CommentDTO dto) {
		dto.setMessage(entity.getMessage());
		dto.setTargetDate(entity.getTargetDate());
		dto.setBug(bugDTOMapper.mapToDTO(entity.getBug()));
		dto.setCreator(userDTOMapper.mapToDTO(entity.getCreator()));
	}

	@Override
	protected void mapDTOToEntityFields(CommentDTO dto, Comment entity) {
		entity.setMessage(dto.getMessage());
		entity.setTargetDate(dto.getTargetDate());
		Bug bug = bugDAO.findEntity(dto.getBug().getId());
		bugDTOMapper.mapToEntity(dto.getBug(), bug);
		entity.setBug(bug);
		User user = userDAO.findEntity(dto.getCreator().getId());
		userDTOMapper.mapToEntity(dto.getCreator(), user);
		entity.setCreator(user);
	}

}
