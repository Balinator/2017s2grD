package edu.msg.ro.business.junit.bug.control;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import edu.msg.ro.business.bug.control.CommentService;
import edu.msg.ro.business.bug.dao.CommentDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.CommentDTO;
import edu.msg.ro.business.bug.dto.mapper.CommentDTOMapper;
import edu.msg.ro.persistence.bug.entity.Comment;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {

	@InjectMocks
	CommentService commentService;

	@Mock
	private CommentDAO commentDAO;

	@Mock
	private CommentDTOMapper commentDTOMapper;

	@Test
	public void createCommentTest() {
		commentService.createComment(new CommentDTO());
		Mockito.verify(commentDTOMapper, Mockito.times(1)).mapToEntity(Mockito.any(CommentDTO.class),
				Mockito.any(Comment.class));
		Mockito.verify(commentDAO, Mockito.times(1)).persistEntity(Mockito.any(Comment.class));
		Mockito.verify(commentDTOMapper, Mockito.times(1)).mapToDTO(Mockito.any(Comment.class));
		Mockito.verify(commentDAO, Mockito.times(1)).findEntity(Mockito.any(Long.class));
	}

	@Test
	public void getAllCommentForBugTest() {
		commentService.getAllCommentForBug(new BugDTO());
		Mockito.verify(commentDTOMapper, Mockito.times(1)).mapToDTOs((java.util.List<Comment>) Mockito.any(List.class));
		Mockito.verify(commentDAO, Mockito.times(1)).getAllCommentForBug(Mockito.any(Long.class));
	}
}
