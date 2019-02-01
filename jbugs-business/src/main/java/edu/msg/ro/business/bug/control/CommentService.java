package edu.msg.ro.business.bug.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dao.CommentDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.CommentDTO;
import edu.msg.ro.business.bug.dto.mapper.CommentDTOMapper;
import edu.msg.ro.persistence.bug.entity.Comment;

@Stateless
public class CommentService {

	@EJB
	private CommentDAO commentDAO;

	@EJB
	private CommentDTOMapper commentDTOMapper;

	public CommentDTO createComment(CommentDTO dto) {
		Comment comment = new Comment();
		commentDTOMapper.mapToEntity(dto, comment);
		commentDAO.persistEntity(comment);
		return commentDTOMapper.mapToDTO(commentDAO.findEntity(comment.getId()));

	}

	public List<CommentDTO> getAllCommentForBug(BugDTO bug) {
		return commentDTOMapper.mapToDTOs(commentDAO.getAllCommentForBug(bug.getId()));
	}

}
