package ru.myhome.model.intefaces;

import java.sql.Date;
import java.sql.Time;

public interface Worktime {

	public Date getDate();
	public Time getStarttime();
	public Time getEndtime();
	public void setDate(Date date);
	public void setStarttime(Time a);
	public void setEndtime(Time b);
	public Workday getWorkday();
	public void setWorkday(Workday workday);
	public void print();
}
