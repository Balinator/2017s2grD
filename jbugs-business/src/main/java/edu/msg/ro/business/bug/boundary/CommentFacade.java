package edu.msg.ro.business.bug.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.control.CommentService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.CommentDTO;

@Stateless
public class CommentFacade {

	@EJB
	private CommentService commentService;

	public CommentDTO createComment(CommentDTO dto) {
		return commentService.createComment(dto);
	}

	public List<CommentDTO> getAllCommentForBug(BugDTO bug) {
		return commentService.getAllCommentForBug(bug);
	}

}
