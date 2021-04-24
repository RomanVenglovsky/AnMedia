package ru.myhome.bridge;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import ru.myhome.model.Person;
import ru.myhome.model.Worktime;

public interface BridgeInterface {
	
	Optional<Person> validateUser(String login, String password);
	Map<LocalDate,Worktime> getWorktimeList();
	Map<LocalDate,Worktime> getWorktimeList(Person person);
	void addWorktime(Worktime worktime);
}
