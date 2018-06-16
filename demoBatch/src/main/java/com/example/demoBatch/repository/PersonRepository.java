package com.example.demoBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoBatch.model.Person;

@Repository("PersonRepository")
public interface PersonRepository extends JpaRepository<Person, Integer>{
}
