package scheduling;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class ShowDateTimeAutomatic {

	@Schedule(second = "*/30", minute = "*", hour = "*")
	public void doShowTime() {
		Date d = new Date();
		if (d.getSeconds() == 10) {
			throw new RuntimeException();
		}
		System.out.println("ShowDateTimeAutomatic: doShowTime:" + new Date());
	}

}