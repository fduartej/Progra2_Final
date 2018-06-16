package com.example.demoBatch.service;

import java.util.List;

import com.example.demoBatch.model.Person;

public interface PersonService {

	public abstract List<Person> listAll();
	public abstract Person buscarXId(int id);
	public abstract Person actualizar(Person person);
}
