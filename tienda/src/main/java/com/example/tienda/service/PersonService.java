package com.example.tienda.service;

import java.util.List;

import com.example.tienda.model.Person;

public interface PersonService {

	public abstract List<Person> listAll();
	public abstract Person buscarXId(int id);
}
