package com.netcracker.edu;

import com.netcracker.edu.dao.DefaultPersonDao;
import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;

import java.util.UUID;

public class Main {

    public static void main(String[] args){
        Person person = new Person("Alex", (byte) 26);

        DefaultPersonDao defaultPersonDao = new DefaultPersonDao();

        String id = defaultPersonDao.savePerson(person);

        try {
            defaultPersonDao.getPerson(UUID.randomUUID().toString());
        } catch (PersonNotFoundException | NotPersonException e) {
            e.printStackTrace();
        }
    }
}
