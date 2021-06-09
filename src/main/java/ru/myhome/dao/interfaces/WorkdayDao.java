package ru.myhome.dao.interfaces;

import java.sql.Date;
import java.util.Optional;

import ru.myhome.model.Workday;
import ru.myhome.model.WorkdayPK;


public interface WorkdayDao {

	void addWorkday(Workday workday);
	boolean existWorkday(WorkdayPK id);
	void updateWorkday(Workday workday);
	void deleteWorkday(Date date, int personId);
	Optional<Workday> getWorkday(WorkdayPK id);
	//void addTimeToWorkday()
	
}
