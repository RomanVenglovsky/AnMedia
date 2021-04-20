package ru.myhome.bridge;

import java.time.LocalDate;
import java.util.Map;

import ru.myhome.model.Person;
import ru.myhome.model.Worktime;

public interface BridgeInterface {
	
	boolean validateUser(String login, String password);
	Map<LocalDate,Worktime> getWorktimeList();
	Map<LocalDate,? extends Worktime> getWorktimeList(Person person);
	void addWorktime(Worktime worktime);
}
