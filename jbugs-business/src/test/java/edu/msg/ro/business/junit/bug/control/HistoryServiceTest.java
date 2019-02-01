package edu.msg.ro.business.junit.bug.control;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.control.HistoryService;
import edu.msg.ro.business.bug.dao.HistoryDAO;
import edu.msg.ro.business.bug.dto.mapper.HistoryDTOMapper;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTest {
	@InjectMocks
	HistoryService historyService;

	@Mock
	private HistoryDAO historyDAO;

	@Mock
	private HistoryDTOMapper historyDTOMapper;

	@Test
	public void getAllHistoryTest() {
		historyService.getAllHistory();
		Mockito.verify(historyDTOMapper, Mockito.times(1)).mapToDTOs(Mockito.anyList());
		Mockito.verify(historyDAO, Mockito.times(1)).getAllHistory();
	}
}
