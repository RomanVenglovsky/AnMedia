package ru.myhome.model.intefaces;

import java.util.Date;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
public interface Workday {
	
	public Person getPerson();
	public void setPerson(Person person);
	public void print();
	public Date getDate();
	public void setId(WorkdayPK id);
	public WorkdayPK getId();
	//public void setDate(Date date);
}
