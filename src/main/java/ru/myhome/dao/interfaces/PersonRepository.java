package ru.myhome.dao.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.Person;



public interface PersonRepository extends CrudRepository<Person, Integer>{
	List<Person> findAll();
	Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
	Optional<Person> findByPhone(String number);
	boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
