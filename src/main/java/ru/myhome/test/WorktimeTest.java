package ru.myhome.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import ru.myhome.model.intefaces.Worktime;

public class WorktimeTest implements Worktime{
	
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	
	
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public LocalTime getStartTime() {
		return startTime;
	}
	@Override
	public void setStartTime(LocalTime a) {
		this.startTime = a;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fDate = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		return String.format("%s %tR - %tR", getDate().format(fDate), getStartTime(), getEndTime());
	}
}