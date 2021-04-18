package ru.myhome.test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import ru.myhome.model.intefaces.Workday;
import ru.myhome.model.intefaces.Worktime;

public class WorktimeTest implements Worktime{
	
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	
	
	public Time getEndtime() {
		return Time.valueOf(endTime);
	}
	@Override
	public void setEndtime(Time endTime) {
		this.endTime = endTime.toLocalTime();
	}
	public WorktimeTest() {
	}
	public WorktimeTest(LocalDate date, LocalTime a, LocalTime b) {
		super();
		this.date = date;
		this.startTime = a;
		this.endTime = b;
		//System.out.println()
	}
	@Override
	public Date getDate() {
		return Date.valueOf(date);
	}
	@Override
	public void setDate(Date date) {
		this.date = date.toLocalDate();
	}
	@Override
	public Time getStarttime() {
		return Time.valueOf(startTime);
	}
	@Override
	public void setStarttime(Time a) {
		this.startTime = a.toLocalTime();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fDate = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		String d = getDate().toLocalDate().format(fDate);
		return String.format("%s %tR - %tR", d, getStarttime(), getEndtime());
	}
	@Override
	public Workday getWorkday() {
		return null;
	}
	@Override
	public void setWorkday(Workday workday) {
	}
	@Override
	public void print() {
	}
}