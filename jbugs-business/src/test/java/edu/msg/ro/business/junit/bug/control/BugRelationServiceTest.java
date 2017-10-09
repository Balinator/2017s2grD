package edu.msg.ro.business.junit.bug.control;

import static org.mockito.Matchers.any;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.control.BugRelationService;
import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dao.BugRelationDAO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.bug.dto.mapper.BugRelationDTOMapper;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.persistence.bug.entity.BugRelation;

@RunWith(MockitoJUnitRunner.class)
public class BugRelationServiceTest {

	@InjectMocks
	BugRelationService bugRelationService;

	@Mock
	private BugRelationDAO bugRelationDAO;

	@Mock
	private BugRelationDTOMapper bugRelationDTOMapper;

	@Mock
	private BugDAO bugDAO;

	@Test(expected = TechnicalExeption.class)
	public void testCreateBug() throws TechnicalExeption {
		bugRelationService.getBugRelation(any(Long.class));

		Mockito.verify(bugRelationDAO, Mockito.times(1)).getBugRelation(any(Long.class));
		Mockito.verify(bugDAO, Mockito.times(1)).findEntity(any(Long.class));
		Mockito.verify(bugRelationDAO, Mockito.times(1)).persistEntity(any(BugRelation.class));
		Mockito.verify(bugRelationDTOMapper, Mockito.times(1)).mapToDTO(any(BugRelation.class));

		ArrayList<BugRelation> list = new ArrayList<>();
		list.add(new BugRelation());
		Mockito.doReturn(list).when(bugRelationDAO).getBugRelation(any(Long.class));
		bugRelationService.getBugRelation(any(Long.class));

		list.add(new BugRelation());
		Mockito.doReturn(list).when(bugRelationDAO).getBugRelation(any(Long.class));
		bugRelationService.getBugRelation(any(Long.class));
	}

	@Test
	public void testUpdateBugRelation() {
		BugRelation bug = new BugRelation();
		BugRelationDTO dto = new BugRelationDTO();
		Mockito.doReturn(bug).when(bugRelationDAO).findEntity(any(Long.class));
		bugRelationService.updateBugRelation(dto);
		Mockito.verify(bugRelationDAO, Mockito.times(1)).findEntity(any(Long.class));
		Mockito.verify(bugRelationDTOMapper, Mockito.times(1)).mapToEntity(any(BugRelationDTO.class),
				any(BugRelation.class));
		Mockito.verify(bugRelationDTOMapper, Mockito.times(1)).mapToDTO(any(BugRelation.class));
	}
}
