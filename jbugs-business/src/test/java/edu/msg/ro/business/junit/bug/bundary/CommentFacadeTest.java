package edu.msg.ro.business.junit.bug.bundary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.boundary.CommentFacade;
import edu.msg.ro.business.bug.control.CommentService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.CommentDTO;
import edu.msg.ro.business.common.exception.TechnicalExeption;

@RunWith(MockitoJUnitRunner.class)
public class CommentFacadeTest {

	@InjectMocks
	CommentFacade commentFacade;

	@Mock
	private CommentService commentService;

	@Test
	public void createCommentTest() throws TechnicalExeption {
		commentFacade.createComment(new CommentDTO());
		Mockito.verify(commentService, Mockito.times(1)).createComment(Mockito.any(CommentDTO.class));
	}

	@Test
	public void getAllCommentForBugTest() throws TechnicalExeption {
		commentFacade.getAllCommentForBug(new BugDTO());
		Mockito.verify(commentService, Mockito.times(1)).getAllCommentForBug(Mockito.any(BugDTO.class));
	}
}
