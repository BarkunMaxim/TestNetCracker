package com.netcracker.edu.service;

import com.netcracker.edu.dao.DefaultPersonDao;
import com.netcracker.edu.dao.PersonDao;
import com.netcracker.edu.dto.Employer;
import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;

import java.util.UUID;

public class DefaultPersonService implements PersonService {

    private PersonDao personDao = new DefaultPersonDao();

    public UUID save(Employer employer) {
        Person person = createPerson(employer);
        String id = personDao.savePerson(person);
        return UUID.fromString(id);
    }

    private Person createPerson(Employer employer){
        return new Person(employer.getName(),(byte) employer.getAge());
    }

    public Person get(UUID uuid) {
        Person person = null;

        try{
            person = personDao.getPerson(uuid.toString());
        }catch (PersonNotFoundException | NotPersonException e){
            System.err.println("ERROR");
        }
        return person;
    }
}
