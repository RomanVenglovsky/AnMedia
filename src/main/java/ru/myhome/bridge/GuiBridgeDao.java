package ru.myhome.bridge;

import java.time.LocalDate;
import java.util.Map;

import ru.myhome.model.intefaces.Person;
import ru.myhome.model.intefaces.Worktime;

public class GuiBridgeDao implements BridgeInterface{

	
	
	
	@Override
	public boolean validateUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<LocalDate, Worktime> getWorktimeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<LocalDate, Worktime> getWorktimeList(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWorktime(Worktime worktime) {
		// TODO Auto-generated method stub
		
	}

}
