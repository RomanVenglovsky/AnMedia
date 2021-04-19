package ru.myhome.dao.interfaces;

import java.sql.Date;

import ru.myhome.model.DbModelWorkday;
import ru.myhome.model.DbModelWorkdayPK;


public interface WorkdayDao {

	void addWorkday(DbModelWorkday workday);
	boolean existWorkday(DbModelWorkdayPK id);
	void updateWorkday(DbModelWorkday workday);
	void deleteWorkday(Date date, int personId);
	DbModelWorkday getWorkday(DbModelWorkdayPK id);
	//void addTimeToWorkday()
	
}
