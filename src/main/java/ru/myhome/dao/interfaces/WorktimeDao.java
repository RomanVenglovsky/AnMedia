package ru.myhome.dao.interfaces;

import java.util.List;

import ru.myhome.model.intefaces.Worktime;

public interface WorktimeDao {
	
	void addWorktime(Worktime worktime);
	void updateWorktime(Worktime worktime);
	List<Worktime> showAllRecord();
	void deletWorktime(Worktime worktime);
	public Worktime getWorktime(int id);
	void deleteById(Integer id);

}
