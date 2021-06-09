package ru.myhome.model;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalTime;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the workdays database table.
 * 
 */
@Entity
@Table(name="workdays")
@NamedQuery(name="Workday.findAll", query="SELECT w FROM Workday w")
public class Workday implements Serializable{
	@Override
	public String toString() {
		return "Workday [id=" + id + "]";
	}
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkdayPK id;

	private double k1;

	private double k15;

	private double k2;

	private double summ;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personId", insertable=false, updatable=false)
	private Person person;

	//bi-directional many-to-one association to Worktime
	@OneToMany(mappedBy="workday",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Worktime> worktimes;

	public Workday() {
	}
	public Workday(WorkdayPK id) {
		setId(id);
	}

	/*public void addWorktime(Worktime wt) {
		
	}*/
	public WorkdayPK getId() {
		return this.id;
	}
	public void setId(WorkdayPK id) {
		this.id = (WorkdayPK) id;
	}
	public Date getDate() {
		return this.id.getDate();
	}

	/*public void setDate(Date date) {
		this.id.setDate(date);
	}*/
	public void updateHourse() {
		double k=0, k2=0, sum=0;
		final LocalTime startDay = LocalTime.parse("10:00:00");
		final LocalTime endDay = LocalTime.parse("22:00:00");
		
		for(Worktime item: worktimes){
			
			LocalTime start = item.getStarttime().toLocalTime();
			LocalTime end = item.getEndtime().toLocalTime();
			
			if (end.equals(LocalTime.parse("24:00:00")))
				end = LocalTime.parse("23:59:59");
			
			if(start.isBefore(startDay)) {
				k2 += (startDay.toSecondOfDay()-start.toSecondOfDay())/3600.0;
				start = startDay;
			}
			if(end.isAfter(endDay)) {
				k2 += (end.toSecondOfDay()-endDay.toSecondOfDay())/3600.0;
				end = endDay;
			}
			k += (end.toSecondOfDay()-start.toSecondOfDay())/3600.0;
			
			k = Math.round(k*100)/100.0;
			k2 = Math.round(k2*100)/100.0;
			sum += k+k2*2;
		}
		this.k2 = k2;
		
	}

	
	public double getK1() {
		return this.k1;
	}

	public void setK1(double k1) {
		this.k1 = k1;
	}

	public double getK15() {
		return this.k15;
	}

	public void setK15(double k15) {
		this.k15 = k15;
	}

	public double getK2() {
		return this.k2;
	}

	public void setK2(double k2) {
		this.k2 = k2;
	}

	public double getSumm() {
		return this.summ;
	}

	public void setSumm(double summ) {
		this.summ = summ;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = (Person) person;
		/*this.person.setFirstName(person.getFirstName());
		this.person.setLastName(person.getLastName());
		this.person.setPhone(person.getPhone());
		this.person.setPasword(person.getPasword());
		this.person.setRate(person.getRate());*/
		
	}

	public List<Worktime> getWorktimes() {
		return this.worktimes;
	}

	public void setWorktimes(List<Worktime> worktimes) {
		this.worktimes = worktimes;
	}

	public Worktime addWorktime(Worktime worktime) {
		getWorktimes().add(worktime);
		
		worktime.setWorkday(this);

		return worktime;
	}

	public Worktime removeWorktime(Worktime worktime) {
		getWorktimes().remove(worktime);
		worktime.setWorkday(null);

		return worktime;
	}
	public void print() {
		System.out.println(this.id.getDate());
		for(Worktime wtTemp: worktimes) {
			wtTemp.print();
		}
	}
}