package com.netcracker.edu.dao;

import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;
import com.netcracker.edu.storage.TemporaryStorage;

import java.util.UUID;

public class DefaultPersonDao implements PersonDao {

    private TemporaryStorage storage = TemporaryStorage.getInstance();

    public DefaultPersonDao(){
    }


    public String savePerson(Person person) {
        String id = UUID.randomUUID().toString();
        person.setId(id);
        storage.insertEntity(id,person);
        return  id;

    }

    public Person getPerson(String id) throws PersonNotFoundException, NotPersonException {
        Object entity = storage.getEntity(id);
        if(entity == null){
            throw new PersonNotFoundException();
        }
        if(!Person.class.equals(entity.getClass())){
            throw new NotPersonException();
        }

        return (Person) entity;
    }
}
