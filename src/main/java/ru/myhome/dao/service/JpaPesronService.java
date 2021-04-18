package ru.myhome.dao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.myhome.dao.interfaces.PersonDao;
import ru.myhome.dao.interfaces.PersonRepository;
import ru.myhome.model.intefaces.Person;

@Service("jpaPesronService")
@Transactional
@Repository
public class JpaPesronService implements PersonDao{

	@Autowired
	private PersonRepository pr;
	
	@PersistenceContext
	private EntityManager em;
	
	public PersonRepository getPersonRepository() {
		return pr;
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public void addPerson(Person person) {
		pr.save(person);
	}

	@Override
	public Person findByName(String firstName, String lastName) {
		return pr.findByFirstNameAndLastName(firstName, lastName).get();
	}

	@Override
	public boolean exists(String firstName, String lastName) {
		return pr.existsByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public Person findById(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public Person findByPhoneNumber(String number) {
		return pr.findByPhone(number).get();
	}

}
