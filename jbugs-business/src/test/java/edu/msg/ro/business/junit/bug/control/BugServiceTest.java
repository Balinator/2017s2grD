package edu.msg.ro.business.junit.bug.control;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.control.BugService;
import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.business.util.TestHelper;
import edu.msg.ro.persistence.bug.entity.Bug;

@RunWith(MockitoJUnitRunner.class)
public class BugServiceTest {

	@InjectMocks
	BugService bugService;

	@Mock
	BugDAO bugDAO;

	@Mock
	BugDTOMapper bugDTOMapper;

	TestHelper th = new TestHelper();

	@Test
	public void testCreateBug() {
		BugDTO bugDTO = new BugDTO();
		Bug bug = new Bug();
		bugService.createBug(bugDTO);
		verify(bugDTOMapper, times(1)).mapToEntity(bugDTO, bug);
	}
}
