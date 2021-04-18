package ru.myhome.dao.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.myhome.dao.interfaces.WorkdayDao;
import ru.myhome.dao.interfaces.WorkdayRepository;
import ru.myhome.model.intefaces.Workday;
import ru.myhome.model.intefaces.WorkdayPK;

//import ru.myhome.model.Workday;
//import ru.myhome.model.WorkdayPK;


@Service("jpaWorkdayService")
@Transactional
@Repository
public class JpaWorkdayService implements WorkdayDao{

	@Autowired
	private WorkdayRepository wdr;
	
	@Override
	public void addWorkday(Workday workday) {
		wdr.save(workday);
	}

	@Override
	public boolean existWorkday(WorkdayPK id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateWorkday(Workday workday) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorkday(Date date, int personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Workday getWorkday(WorkdayPK id) {
		return wdr.findById(id).get();
		
	}

}
