package ru.myhome.dao.test;

import java.time.LocalDate;
import java.util.Map;

import ru.myhome.bridge.BridgeInterface;
import ru.myhome.model.intefaces.Person;
import ru.myhome.model.intefaces.Worktime;
import ru.myhome.test.TestUser;
import ru.myhome.test.TestWorktimeList;

public class TestBridge implements BridgeInterface{

	
	private TestUser person;
	private TestWorktimeList wtList;
	
	public TestBridge(){
		person = new TestUser();
		wtList = new TestWorktimeList();
	}
	
	@Override
	public boolean validateUser(String login, String password) {
		System.out.println("Login: " + login + "\nPassword: " + password);
		TestUser user = new TestUser(login, password);
		return person.equals(user);
	}

	@Override
	public Map<LocalDate, Worktime> getWorktimeList() {
		// TODO Auto-generated method stub
		return wtList.getTimeList();
	}

	@Override
	public Map<LocalDate, Worktime> getWorktimeList(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
