package edu.msg.ro.business.junit.bug.interceptor;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.interceptor.HistoryInterceptor;

@RunWith(MockitoJUnitRunner.class)
public class HistoryInterceptorTest {

	@InjectMocks
	private HistoryInterceptor historyInterceptor;

	@Test
	public void hashTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		historyInterceptor.hash(new byte[100]);
	}
}
