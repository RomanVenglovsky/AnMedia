package ru.myhome.dao.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.myhome.dao.interfaces.PersonDao;
import ru.myhome.dao.interfaces.PersonRepository;
import ru.myhome.model.Person;

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
	public Optional<Person> findByName(String firstName, String lastName) {
		return pr.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public boolean exists(String firstName, String lastName) {
		return pr.existsByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public Optional<Person> findById(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}

	@Override
	public Optional<Person> findByPhoneNumber(String number) {
		return pr.findByPhone(number);
	}

}
