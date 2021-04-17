package ru.myhome.model.intefaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Worktime {

	public LocalDate getDate();
	public LocalTime getStartTime();
	public LocalTime getEndTime();
	public void setDate(LocalDate date);
	public void setStartTime(LocalTime a);
	public void setEndTime(LocalTime b);
}
