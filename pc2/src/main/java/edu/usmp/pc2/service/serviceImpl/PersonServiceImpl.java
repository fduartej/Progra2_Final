package edu.usmp.pc2.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.usmp.pc2.model.Person;
import edu.usmp.pc2.repository.PersonRepository;
import edu.usmp.pc2.service.PersonService;

@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService{
	public static final Log Log = LogFactory.getLog(PersonServiceImpl.class);
	
	@Autowired
	@Qualifier("PersonRepository")
	private PersonRepository personRepository;

	@Override
	public Person addPerson(Person person) {
		Log.info("PersonServiceImpl addPerson()");
		return personRepository.save(person);
	}

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
	
	
}
