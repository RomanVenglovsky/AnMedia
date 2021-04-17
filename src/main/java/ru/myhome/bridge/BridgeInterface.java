package ru.myhome.bridge;

import java.time.LocalDate;
import java.util.Map;

import ru.myhome.model.intefaces.Person;
import ru.myhome.model.intefaces.Worktime;

public interface BridgeInterface {
	
	boolean validateUser(String login, String password);
	Map<LocalDate,Worktime> getWorktimeList();
	Map<LocalDate,Worktime> getWorktimeList(Person person);
	void addWorktime(Worktime worktime);
}
