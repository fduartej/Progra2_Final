package com.example.demoBatch.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demoBatch.model.Person;
import com.example.demoBatch.repository.PersonRepository;
import com.example.demoBatch.service.PersonService;

@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService{
	public static final Log Log = LogFactory.getLog(PersonServiceImpl.class);
	
	@Autowired
	@Qualifier("PersonRepository")
	private PersonRepository personRepository;

	@Override
	public List<Person> listAll() {
		Log.info("PersonServiceImpl listAll()");
		return personRepository.findAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Person buscarXId(int id) {
		Log.info("PersonServiceImpl buscarXId()");
		Optional person = personRepository.findById(id);
		if (person.isPresent()) {
		return (Person) person.get();
		}
		return null ;
	}

	@Override
	public Person actualizar(Person person) {
		Log.info("PersonServiceImpl actualizar()");
		return personRepository.save(person);
	}
	
	
}
