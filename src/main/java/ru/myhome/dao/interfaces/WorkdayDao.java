package ru.myhome.dao.interfaces;

import java.sql.Date;

import ru.myhome.model.Workday;
import ru.myhome.model.WorkdayPK;


public interface WorkdayDao {

	void addWorkday(Workday workday);
	boolean existWorkday(WorkdayPK id);
	void updateWorkday(Workday workday);
	void deleteWorkday(Date date, int personId);
	Workday getWorkday(WorkdayPK id);
	//void addTimeToWorkday()
	
}
