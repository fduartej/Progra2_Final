package com.example.dashboard.service;

import java.util.List;

import com.example.dashboard.model.Person;

public interface PersonService {

	public abstract List<Person> listAll();
	public abstract Person buscarXId(int id);
	public abstract int contar();
}
