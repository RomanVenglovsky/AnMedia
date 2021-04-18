package ru.myhome.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import ru.myhome.model.intefaces.Workday;
import ru.myhome.model.intefaces.Worktime;


/**
 * The persistent class for the worktime database table.
 * 
 */
@Entity
@NamedQuery(name="Worktime.findAll", query="SELECT w FROM Worktime w")
public class DbModelWorktime implements Serializable, Worktime {
	private static final long serialVersionUID = 1L;

	@Id
	private int intervalId;

	private Time endtime;

	private Time starttime;
	
	//bi-directional many-to-one association to Workday
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="day", referencedColumnName="date"),
		@JoinColumn(name="persaonId", referencedColumnName="personId")
		})
	private Workday workday;
	
	public int getIntervalId() {
		return this.intervalId;
	}

	public void setIntervalId(int intervalId) {
		this.intervalId = intervalId;
	}
	@Override
	public Time getEndtime() {
		return this.endtime;
	}
	@Override
	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}
	@Override
	public Time getStarttime() {
		return this.starttime;
	}
	@Override
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

	@Override
	public Date getDate() {
		this.workday.getDate();
		return null;
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		
	}
}