package ru.myhome.dao.interfaces;

import java.util.List;
import java.util.Optional;

import ru.myhome.model.Person;


public interface PersonDao {
	
	List<Person> findAll();
	Optional<Person> findByName(String firstName, String lastName);
	Optional<Person> findById(int id);
	Optional<Person> findByPhoneNumber(String number);
	void addPerson(Person person);
	boolean exists(String firstName, String lastName);
}
