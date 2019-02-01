package edu.msg.ro.business.junit.bug.control;

import static org.mockito.Matchers.any;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import edu.msg.ro.business.bug.control.BugRelationService;
import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dao.BugRelationDAO;
import edu.msg.ro.business.bug.dto.BugRelationDTO;
import edu.msg.ro.business.bug.dto.mapper.BugRelationDTOMapper;
import edu.msg.ro.business.bug.enums.BugRelationEnum;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.persistence.bug.entity.Bug;
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
	public void testUpdateBugRelation()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		BugRelation bug = new BugRelation();
		BugRelationDTO dto = new BugRelationDTO();
		Mockito.doReturn(bug).when(bugRelationDAO).findEntity(any(Long.class));
		Mockito.doAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				((BugRelation) args[1]).setRelation(BugRelationEnum.DIRECT_LINK.getKey());
				return null;
			}
		}).when(bugRelationDTOMapper).mapToEntity(Mockito.any(BugRelationDTO.class), Mockito.any(BugRelation.class));
		bugRelationService.updateBugRelation(dto);
		Mockito.verify(bugRelationDTOMapper, Mockito.times(1)).mapToEntity(any(BugRelationDTO.class),
				any(BugRelation.class));
		Mockito.verify(bugRelationDTOMapper, Mockito.times(1)).mapToDTO(any(BugRelation.class));

		Mockito.doAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				((BugRelation) args[1]).setBug2(new Bug());
				return null;
			}
		}).when(bugRelationDTOMapper).mapToEntity(Mockito.any(BugRelationDTO.class), Mockito.any(BugRelation.class));
		bugRelationService.updateBugRelation(dto);
		Mockito.verify(bugRelationDAO, Mockito.times(1)).persistEntity(any(BugRelation.class));

		Mockito.doAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				((BugRelation) args[1]).setRelation(BugRelationEnum.NONE.getKey());
				return null;
			}
		}).when(bugRelationDTOMapper).mapToEntity(Mockito.any(BugRelationDTO.class), Mockito.any(BugRelation.class));
		bugRelationService.updateBugRelation(dto);
		Mockito.verify(bugRelationDAO, Mockito.times(1)).persistEntity(any(BugRelation.class));

		dto.setId(1L);
		Field idF = bug.getClass().getDeclaredField("id");
		idF.setAccessible(true);
		idF.set(bug, 1L);
		Mockito.doReturn(bug).when(bugRelationDAO).findEntity(any(Long.class));
		bugRelationService.updateBugRelation(dto);
		Mockito.verify(bugRelationDAO, Mockito.times(1)).findEntity(any(Long.class));
	}
}
