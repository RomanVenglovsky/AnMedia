package ru.myhome.dao.test;

import java.util.List;

import ru.myhome.dao.interfaces.WorktimeDao;
import ru.myhome.model.DbModelWorktime;

public class TestWorktimeDao implements WorktimeDao{

	
	@Override
	public void addWorktime(DbModelWorktime worktime) {
	}

	@Override
	public void updateWorktime(DbModelWorktime worktime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DbModelWorktime> showAllRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletWorktime(DbModelWorktime worktime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DbModelWorktime getWorktime(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
