package ru.myhome.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import ru.myhome.model.intefaces.Worktime;

public class WorktimeTest implements Worktime{
	
	private LocalDate date;
	private LocalTime a;
	private LocalTime b;
	
	public WorktimeTest() {
		
	}
	public WorktimeTest(LocalDate date, LocalTime a, LocalTime b) {
		super();
		this.date = date;
		this.a = a;
		this.b = b;
		//System.out.println()
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getA() {
		return a;
	}
	public void setA(LocalTime a) {
		this.a = a;
	}
	public LocalTime getB() {
		return b;
	}
	public void setB(LocalTime b) {
		this.b = b;
	}
	@Override
	public String toString() {
		DateTimeFormatter fDate = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		return String.format("%s %tR - %tR", getDate().format(fDate), getA(), getB());
	}
}