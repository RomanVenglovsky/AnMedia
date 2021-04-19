package ru.myhome.model.intefaces;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface WorkdayPK {
	
	public Date getDate();
	public void setDate(Date date);
	public int getPersonId();
	public void setPersonId(int personId);
	public boolean equals(Object other);
	public int hashCode();
}
