package ru.myhome.dao.interfaces;

import java.util.List;

import ru.myhome.model.intefaces.Person;

public interface PersonDao {
	
	List<Person> findAll();
	Person findByName(String firstName, String lastName);
	Person findById(int id);
	Person findByPhoneNumber(String number);
	void addPerson(Person person);
	boolean exists(String firstName, String lastName);
}
