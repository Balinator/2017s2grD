package edu.msg.ro.business.junit.bug.control;

import static org.mockito.Matchers.any;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import edu.msg.ro.business.bug.control.BugService;
import edu.msg.ro.business.bug.dao.BugDAO;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.business.util.TestHelper;

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
		BugDTO b = bugService.createBug(any(BugDTO.class));
		// verify();
	}
}
