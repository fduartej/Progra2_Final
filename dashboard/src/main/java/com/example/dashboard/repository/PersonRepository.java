package com.example.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dashboard.model.Person;

@Repository("PersonRepository")
public interface PersonRepository extends JpaRepository<Person, Integer>{
}
