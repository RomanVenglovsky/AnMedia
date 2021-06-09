package ru.myhome.bridge;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.myhome.dao.BuilderDao;
import ru.myhome.dao.interfaces.PersonDao;
import ru.myhome.dao.interfaces.WorkdayDao;
import ru.myhome.model.Person;
import ru.myhome.model.Worktime;

public class GuiBridgeDao implements BridgeInterface{

	
	
	
	@Override
	public Optional<Person> validateUser(String login, String password) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuilderDao.class)){
			PersonDao personDao = context.getBean("jpaPesronService", PersonDao.class);
			Optional<Person> p = personDao.findByPhoneNumber(login);
			if(p.isPresent()) {
				if(p.get().getPasword().equals(password)) return p;
			}
			return Optional.empty();
		}
	}

	@Override
	public Map<LocalDate, Worktime> getWorktimeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<LocalDate, List<Worktime>> getWorktimeList(Person person) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuilderDao.class)){
			
			WorkdayDao workdayDao = context.getBean("jpaWorkdayService", WorkdayDao.class);
			
			return null;
		}
	}

	@Override
	public void addWorktime(Worktime worktime) {
		// TODO Auto-generated method stub
		
	}

}
