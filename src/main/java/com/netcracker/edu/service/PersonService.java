package com.netcracker.edu.service;

import com.netcracker.edu.dto.Employer;
import com.netcracker.edu.entity.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    UUID save(Employer employer);

    Person get(UUID uuid);

    List<String> saveAll(List<Person> employerList);

    List<Person> findAll();

    Person findByName(String name);

    Person findByAge(byte age);

    Person findByAgeAndName(String name, byte age);
}
