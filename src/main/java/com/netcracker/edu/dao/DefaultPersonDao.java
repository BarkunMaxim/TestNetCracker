package com.netcracker.edu.dao;

import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;
import com.netcracker.edu.storage.TemporaryStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefaultPersonDao implements PersonDao {

    private TemporaryStorage storage = TemporaryStorage.getInstance();

    public DefaultPersonDao() {
    }


    public String savePerson(Person person) {
        String id = UUID.randomUUID().toString();
        person.setId(id);
        storage.insertEntity(id, person);
        return id;

    }

    @Override
    public List<String> saveAll(List<Person> personList) {

        List<String> idList = new ArrayList<>();
        StringBuffer id = null;

        for (Person iterator : personList) {
            id.append(UUID.randomUUID().toString());
            iterator.setId(id.toString());
            storage.insertEntity(id.toString(), iterator);
            idList.add(id.toString());
        }

        return idList;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        List<Object> objectList = storage.getAllEntity();

        for (Object iterator : objectList) {
            personList.add((Person) iterator);
        }
        return personList;
    }

    public Person getPerson(String id) throws PersonNotFoundException, NotPersonException {
        Object entity = storage.getEntity(id);
        if (entity == null) {
            throw new PersonNotFoundException();
        }
        if (!Person.class.equals(entity.getClass())) {
            throw new NotPersonException();
        }

        return (Person) entity;
    }

    @Override
    public Person findByName(String name) throws PersonNotFoundException {
        List<Object> objectList = storage.getAllEntity();
        List<Person> personList = new ArrayList<>();
        for (Object iterator : objectList) {
            personList.add((Person) iterator);
        }

        Person foundPerson = personList.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException());


        return foundPerson;
    }

    @Override
    public Person findByAge(byte age) throws PersonNotFoundException {

        List<Object> objectList = storage.getAllEntity();
        List<Person> personList = new ArrayList<>();
        for (Object iterator : objectList) {
            personList.add((Person) iterator);
        }

        Person foundPerson = personList.stream()
                .filter(person -> person.getAge() == age)
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException());

        return foundPerson;

    }

    @Override
    public void deleteById(UUID uuid) throws PersonNotFoundException {
        storage.deleteEntity(uuid.toString());
    }

    @Override
    public void deleteByName(String name) throws PersonNotFoundException, NotPersonException {
        List<Object> objectList = storage.getAllEntity();
        List<Person> personList = new ArrayList<>();
        for (Object iterator : objectList) {
            personList.add((Person) iterator);
        }

        Person foundPerson = personList.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException());

        storage.deleteEntity(foundPerson.getId());
    }

    @Override
    public void deleteAll() {
        storage.deleteAllPerson();
    }

    @Override
    public Person findByNameAndAge(String name, byte age) throws PersonNotFoundException, NotPersonException {

        List<Object> objectList = storage.getAllEntity();
        List<Person> personList = new ArrayList<>();
        for (Object iterator : objectList) {
            personList.add((Person) iterator);
        }

        Person foundPerson = personList.stream()
                .filter(person -> person.getName().equals(name) && person.getAge() == age)
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException());

        return foundPerson;
    }
}
