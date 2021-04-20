package ru.myhome.test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.myhome.bridge.BridgeInterface;
import ru.myhome.dao.BuilderDao;
import ru.myhome.dao.interfaces.PersonDao;
import ru.myhome.model.Person;
import ru.myhome.model.Worktime;

public class TestBridge implements BridgeInterface{

	
	private TestUser person;
	private TestWorktimeList wtList;
	
	public TestBridge(){
		person = new TestUser();
		wtList = new TestWorktimeList();
	}
	
	@Override
	public boolean validateUser(String login, String password) {
		/*System.out.println("Login: " + login + "\nPassword: " + password);
		TestUser user = new TestUser(login, password);*/
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuilderDao.class);
		PersonDao personDao = context.getBean("jpaPesronService", PersonDao.class);
		Optional<Person> p = personDao.findByPhoneNumber(login);
		if(p.isPresent()) {
			if(p.get().getPasword().equals(password)) return true;
		}
		return false;
	}

	public Map<LocalDate, Worktime> getWorktimeList() {
		// TODO Auto-generated method stub
		return wtList.getTimeList();
	}

	@Override
	public Map<LocalDate, Worktime> getWorktimeList(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWorktime(Worktime worktime) {
		// TODO Auto-generated method stub
		wtList.addWorktime(worktime);
	}
}
