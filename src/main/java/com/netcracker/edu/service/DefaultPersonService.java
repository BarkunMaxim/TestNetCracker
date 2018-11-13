package com.netcracker.edu.service;

import com.netcracker.edu.dao.DefaultPersonDao;
import com.netcracker.edu.dao.PersonDao;
import com.netcracker.edu.dto.Employer;
import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultPersonService implements PersonService {

    private PersonDao personDao = new DefaultPersonDao();

    public UUID save(Employer employer) {
        Person person = createPerson(employer);
        String id = personDao.savePerson(person);
        return UUID.fromString(id);
    }

    private Person createPerson(Employer employer) {
        return new Person(employer.getName(), (byte) employer.getAge());
    }

    public Person get(UUID uuid) {
        Person person = null;

        try {
            person = personDao.getPerson(uuid.toString());
        } catch (PersonNotFoundException | NotPersonException e) {
            System.err.println("ERROR");
        }
        return person;
    }

    @Override
    public List<String> saveAll(List<Person> personList) {

        List<String> idList = null;

        idList = personDao.saveAll(personList);

        return idList;
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person findByName(String name) {
        Person foundPerson = null;

        try {
            foundPerson = personDao.findByName(name);
        } catch (PersonNotFoundException e) {
            e.printStackTrace();
        }

        return foundPerson;
    }

    @Override
    public Person findByAge(byte age) {
        Person foundPerson = null;

        try {
            foundPerson = personDao.findByAge(age);
        } catch (PersonNotFoundException e) {
            e.printStackTrace();
        }

        return foundPerson;
    }

    @Override
    public Person findByAgeAndName(String name, byte age) {
        Person foundPerson = null;

        try {
            foundPerson = personDao.findByNameAndAge(name, age);
        } catch (PersonNotFoundException e) {
            e.printStackTrace();
        } catch (NotPersonException e) {
            e.printStackTrace();
        }

        return foundPerson;
    }
}
