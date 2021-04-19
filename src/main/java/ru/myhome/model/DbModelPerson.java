package ru.myhome.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import ru.myhome.model.intefaces.Person;
import ru.myhome.model.intefaces.Workday;


/**
 * The persistent class for the persons database table.
 * 
 */
@Entity
@Table(name="persons")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class DbModelPerson implements Serializable, Person {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String firstName;

	private String lastName;

	private String pasword;

	private String phone;

	private int rate;

	//bi-directional many-to-one association to Workday
	@OneToMany(mappedBy="person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DbModelWorkday> workdays;

	public DbModelPerson() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasword() {
		return this.pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return String.format("%-3d %-7s %-15s %10s", 
				getId(), getFirstName(), getLastName(), getPhone());
	}

	public List<DbModelWorkday> getWorkdays() {
		return this.workdays;
	}

	public void setWorkdays(List<DbModelWorkday> workdays) {
		this.workdays = workdays;
	}

	public void addWorkday(Workday workday) {
		DbModelWorkday wd = (DbModelWorkday)workday;
		getWorkdays().add(wd);
		workday.setPerson(this);

	}

	public Workday removeWorkday(Workday workday) {
		getWorkdays().remove(workday);
		workday.setPerson(null);

		return workday;
	}
	
	public void showWorkday() {
		for(Workday wdTemp: workdays) {
			wdTemp.print();
		}
	}
	

}