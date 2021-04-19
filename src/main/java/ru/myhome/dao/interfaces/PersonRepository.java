package ru.myhome.dao.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.DbModelPerson;


public interface PersonRepository extends CrudRepository<DbModelPerson, Integer>{
	List<DbModelPerson> findAll();
	Optional<DbModelPerson> findByFirstNameAndLastName(String firstName, String lastName);
	Optional<DbModelPerson> findByPhone(String number);
	boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
