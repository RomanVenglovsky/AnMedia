package ru.myhome.dao.interfaces;

import java.util.List;

import ru.myhome.model.intefaces.Person;

public interface PersonDao {
	
	List<Person> findAll();
	List<Person> findByName(String firstName, String lastName);
	List<Person> findById(int id);
	List<Person> findByPhoneNumber(String number);
	void addPerson(Person person);
	boolean exists(String firstName, String lastName);
}
