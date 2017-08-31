package timer;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@Startup
public class TimeStudy {

	@Schedule(second = "*/30", minute = "*", hour = "*")
	public void doShowTime() {
		Date d = new Date();
		if (d.getSeconds() == 10) {
			throw new RuntimeException();
		}
		System.out.println("ShowDateTimeAutomatic: doShowTime:" + new Date());
	}

	@Resource
	TimerService timerService;

	@PostConstruct
	public void init() {
		final ScheduleExpression expression = new ScheduleExpression();
		expression.second("*/30").minute("*").hour("*");
		timerService.createCalendarTimer(expression);

	}

	@Timeout
	public void timeout(Timer timer) {
		System.out.println("ShowDateTimeProgramatic: timeout occurred");
	}
}
