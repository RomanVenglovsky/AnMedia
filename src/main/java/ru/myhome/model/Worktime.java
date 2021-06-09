package ru.myhome.model;

import java.io.Serializable;
import java.util.Date;
import java.sql.Time;

import javax.persistence.*;

/**
 * The persistent class for the worktime database table.
 * 
 */
@Entity
@NamedQuery(name="Worktime.findAll", query="SELECT w FROM Worktime w")
public class Worktime implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private int intervalId;

	private Time endtime;

	private Time starttime;
	
	//bi-directional many-to-one association to Workday
	//@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@ManyToOne//(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="day", referencedColumnName="date"),
		@JoinColumn(name="persaonId", referencedColumnName="personId")
		})
	private Workday workday;
	
	/*	 
	public Worktime(Time a, Time b, Date d) {
		setStarttime(a);
		setEndtime(b);
		workday = new Workday();
	}*/
	public int getIntervalId() {
		return this.intervalId;
	}

	public void setIntervalId(int intervalId) {
		this.intervalId = intervalId;
	}
	
	public Time getEndtime() {
		return this.endtime;
	}
	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}
	public Time getStarttime() {
		return this.starttime;
	}
	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public Workday getWorkday() {
		return this.workday;
	}
	public void setWorkday(Workday workday) {
		this.workday = workday;
	}
	public void print() {
		System.out.println("\t" + getIntervalId() + "  " + getStarttime() + " - " + getEndtime());
	}
	public Date getDate() {
		return this.workday.getDate();
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		
	}
}