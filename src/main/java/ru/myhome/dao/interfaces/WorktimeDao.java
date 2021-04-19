package ru.myhome.dao.interfaces;

import java.util.List;

import ru.myhome.model.DbModelWorktime;

public interface WorktimeDao {
	
	void addWorktime(DbModelWorktime worktime);
	void updateWorktime(DbModelWorktime worktime);
	List<DbModelWorktime> showAllRecord();
	void deletWorktime(DbModelWorktime worktime);
	public DbModelWorktime getWorktime(int id);
	void deleteById(Integer id);

}
