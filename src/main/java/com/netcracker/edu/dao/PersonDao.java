package com.netcracker.edu.dao;

import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;

import java.util.List;
import java.util.UUID;

//saveAll, findAll,
public interface PersonDao {

    String savePerson(Person person);

    List<String> saveAll(List<Person> personList);

    List<Person> findAll();

    Person getPerson(String id) throws PersonNotFoundException, NotPersonException;

    Person findByName(String name) throws PersonNotFoundException;

    Person findByAge(byte age) throws PersonNotFoundException;

    void deleteById(UUID uuid) throws PersonNotFoundException;

    void deleteByName(String name) throws PersonNotFoundException, NotPersonException;

    void deleteAll();

    Person findByNameAndAge(String name, byte age) throws PersonNotFoundException, NotPersonException;



}
