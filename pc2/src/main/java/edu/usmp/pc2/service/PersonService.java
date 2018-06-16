package edu.usmp.pc2.service;

import java.util.List;
import edu.usmp.pc2.model.Person;

public interface PersonService {

	public abstract Person addPerson(Person person);
	public abstract List<Person> listAll();
	public abstract Person buscarXId(int id);
}
