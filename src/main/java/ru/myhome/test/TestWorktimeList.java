package ru.myhome.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import ru.myhome.model.Worktime;

public class TestWorktimeList {
	
	private Map<LocalDate,Worktime> wtList;
	
	public TestWorktimeList(Map<LocalDate, Worktime> wtList) {
		this.wtList = wtList;
	}
	public TestWorktimeList() {
		wtList = new HashMap<LocalDate, Worktime>();
		//DateTimeFormatter fDate = DateTimeFormatter.ofPattern("dd.MM.YYYY  hh:mm");
		//DateTimeFormatter fTime = DateTimeFormatter.ofPattern("hh:mm");
		LocalTime a = LocalTime.parse("10:00");
		LocalTime b = LocalTime.parse("19:30");
		LocalDate date = LocalDate.now();
		for(int i = 1; i<5; i++) {
			Worktime wt = new WorktimeTest(date.minusDays(6-i), a.plusHours(i), b.plusHours(i));
			//wtList.put(wt.getDate(), wt);
			System.out.println(wt);
			
		}
	}
	
	public Map<LocalDate, Worktime> getTimeList(){
		return wtList;
	}
	public void addWorktime(Worktime wt) {
		wtList.put(wt.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), (WorktimeTest) wt);
	}
}
