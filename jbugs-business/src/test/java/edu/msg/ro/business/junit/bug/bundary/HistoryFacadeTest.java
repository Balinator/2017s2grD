package edu.msg.ro.business.junit.bug.bundary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.boundary.HistoryFacade;
import edu.msg.ro.business.bug.control.HistoryService;
import edu.msg.ro.business.common.exception.TechnicalExeption;

@RunWith(MockitoJUnitRunner.class)
public class HistoryFacadeTest {

	@InjectMocks
	HistoryFacade historyFacade;

	@Mock
	private HistoryService historyService;

	@Test
	public void getAllHistoryTest() throws TechnicalExeption {
		historyFacade.getAllHistory();
		Mockito.verify(historyService, Mockito.times(1)).getAllHistory();
	}

}
