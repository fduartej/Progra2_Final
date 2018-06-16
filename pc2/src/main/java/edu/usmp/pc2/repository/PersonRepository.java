package edu.usmp.pc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.pc2.model.Person;

@Repository("PersonRepository")
public interface PersonRepository 
extends JpaRepository<Person, Integer>{
}
