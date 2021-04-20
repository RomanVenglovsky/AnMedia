package ru.myhome.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the workdays database table.
 * 
 */
@Embeddable
public class WorkdayPK implements Serializable{
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(insertable=false, updatable=false)
	private int personId;

	public WorkdayPK() {
	}
	public WorkdayPK(Date date, int personId) {
		setPersonId(personId);
		setDate(date);
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPersonId() {
		return this.personId;
	}
	@Column(insertable=false, updatable=false)
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkdayPK)) {
			return false;
		}
		WorkdayPK castOther = (WorkdayPK)other;
		return 
			this.date.equals(castOther.getDate())
			&& (this.personId == castOther.getPersonId());
	}
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.personId;
		
		return hash;
	}
}