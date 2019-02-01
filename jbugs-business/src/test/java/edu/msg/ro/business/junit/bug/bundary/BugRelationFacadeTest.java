package edu.msg.ro.business.junit.bug.bundary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.boundary.BugRelationFacade;
import edu.msg.ro.business.bug.control.BugRelationService;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.common.exception.TechnicalExeption;

@RunWith(MockitoJUnitRunner.class)
public class BugRelationFacadeTest {

	@InjectMocks
	BugRelationFacade bugRelationFacade;

	@Mock
	private BugRelationService bugRelationService;

	@Test
	public void getBugRelationTest() throws TechnicalExeption {
		bugRelationFacade.getBugRelation(new BugDTO());
		Mockito.verify(bugRelationService, Mockito.times(1)).getBugRelation(Mockito.any(Long.class));
	}

	@Test
	public void updateBugRelationTest() {
		bugRelationFacade.updateBugRelation(new BugRelationDTO());
		Mockito.verify(bugRelationService, Mockito.times(1)).updateBugRelation(Mockito.any(BugRelationDTO.class));
	}
}
