package ru.myhome.dao.interfaces;

import java.util.List;

import ru.myhome.model.DbModelPerson;

public interface PersonDao {
	
	List<DbModelPerson> findAll();
	DbModelPerson findByName(String firstName, String lastName);
	DbModelPerson findById(int id);
	DbModelPerson findByPhoneNumber(String number);
	void addPerson(DbModelPerson person);
	boolean exists(String firstName, String lastName);
}
