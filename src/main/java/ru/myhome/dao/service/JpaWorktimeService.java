package ru.myhome.dao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.myhome.dao.interfaces.WorkdayDao;
import ru.myhome.dao.interfaces.WorktimeDao;
import ru.myhome.dao.interfaces.WorktimeRepository;
import ru.myhome.model.intefaces.Worktime;

@Service("jpaWorktimeService")
@Transactional
@Repository
public class JpaWorktimeService implements WorktimeDao{
	
	@Autowired
	private WorktimeRepository wtr;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private WorkdayDao wdDao;

	@Override
	public void addWorktime(Worktime worktime) {
		/*Workday wd = worktime.getWorkday();
		if(wdDao.existWorkday(wd.getId()))
			wdDao.updateWorkday(wd);
		else wdDao.addWorkday(wd);*/
		wtr.save(worktime);
		//em.clear();
		
	}

	@Override
	public void updateWorktime(Worktime worktime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletWorktime(Worktime worktime) {
		wtr.delete(worktime);
		
	}

	@Override
	public List<Worktime> showAllRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Worktime getWorktime(int id) {
		return wtr.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		wtr.deleteById(id);
		//em.createQuery(qlString)
		System.out.println("DELETED " + id);
		//em.remove(wtr.findById(id).get());
	}

}
