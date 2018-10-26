package com.netcracker.edu.dao;

import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;

public interface PersonDao {

    String savePerson(Person person);

    Person getPerson(String id) throws PersonNotFoundException, NotPersonException;
}
