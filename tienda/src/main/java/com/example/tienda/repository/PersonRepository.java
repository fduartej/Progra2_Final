package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Person;

@Repository("PersonRepository")
public interface PersonRepository extends JpaRepository<Person, Integer>{
}
