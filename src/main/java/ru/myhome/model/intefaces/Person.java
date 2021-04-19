package ru.myhome.model.intefaces;

import java.util.List;

import javax.persistence.MappedSuperclass;

import ru.myhome.model.DbModelWorkday;


@MappedSuperclass
public interface Person {

	public int getId();
	public void setId(int id);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getPasword();
	public void setPasword(String pasword);
	public String getPhone();
	public void setPhone(String phone);
	public int getRate();
	public void setRate(int rate);
	public List<DbModelWorkday> getWorkdays();
	public void setWorkdays(List<DbModelWorkday> workdays);
	public void addWorkday(Workday workday);
	public Workday removeWorkday(Workday workday);
	//public void showWorkday();
}
