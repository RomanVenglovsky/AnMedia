package ru.myhome.model.intefaces;

import java.sql.Date;

public interface Workday {
	
	public Person getPerson();
	public void setPerson(Person person);
	public void print();
	public Date getDate();
	public void setId(WorkdayPK id);
	public WorkdayPK getId();
	//public void setDate(Date date);
}
