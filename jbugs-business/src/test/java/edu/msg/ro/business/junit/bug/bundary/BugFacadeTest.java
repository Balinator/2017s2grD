package edu.msg.ro.business.junit.bug.bundary;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.control.BugService;
import edu.msg.ro.business.bug.dto.BugDTO;

@RunWith(MockitoJUnitRunner.class)
public class BugFacadeTest {

	@InjectMocks
	BugFacade bugFacede;

	@Mock
	BugService bugService;

	/**
	 * check create bug
	 */

	@Test
	public void testCreateBug() {
		BugDTO newBugDTO = new BugDTO();
		bugFacede.createBug(newBugDTO);
		verify(bugService, times(1)).createBug(newBugDTO);
	}

	/**
	 * check bug update
	 */
	@Test
	public void testUpdateBug() {
		BugDTO newBugDTO = new BugDTO();
		bugFacede.updateBug(newBugDTO);
		verify(bugService, times(1)).updateBug(newBugDTO);
	}

	/**
	 * test get bug list
	 */
	@Test
	public void testGetAllBug() {
		bugFacede.getAllbugs();
		verify(bugService, times(1)).getAllBugs();
	}

	/**
	 * test delete bug
	 */
	@Test
	public void testDeeleteBug() {
		BugDTO newBugDTO = new BugDTO();
		bugFacede.deleteBug(newBugDTO);
		verify(bugService, times(1)).deleteBug(newBugDTO);
	}
}
