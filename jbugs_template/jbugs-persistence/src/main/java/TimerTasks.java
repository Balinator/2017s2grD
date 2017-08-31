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
public class TimerTasks {

	@Resource
	TimerService timerService;

	@PostConstruct
	public void doSometimgWithTime() {
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*").minute("*/1").second("*");
		Timer timer = timerService.createCalendarTimer(schedule);
		System.out.println("init");
	}

	@Timeout
	public void timeout(Timer timer) {
		System.out.println("@Timeout Automatic timeout occured! New.");
	}

	@Schedule(minute = "*/3", hour = "*", second = "*")
	public void automaticTimeout() {
		System.out.println("@Schedule Automatic timeout occured! New.");
	}

}
