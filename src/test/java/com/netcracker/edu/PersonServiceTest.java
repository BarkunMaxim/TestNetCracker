package com.netcracker.edu;

import com.netcracker.edu.dao.PersonDao;
import com.netcracker.edu.dto.Employer;
import com.netcracker.edu.entity.Person;
import com.netcracker.edu.exception.NotPersonException;
import com.netcracker.edu.exception.PersonNotFoundException;
import com.netcracker.edu.service.DefaultPersonService;
import com.netcracker.edu.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService = new DefaultPersonService();

    @Mock
    private PersonDao personDao;

    private Employer employer;
    private Person person;
    private String id;
    private UUID uuid;

    @BeforeEach
    public void init(){
        employer = new Employer();
        employer.setAge(30);
        employer.setName("Dima");
        employer.setSurname("Peshkin");

        uuid = UUID.randomUUID();

        id = UUID.randomUUID().toString();

        person = new Person("Alex" ,(byte) 25);
    }

    @Test
    public void save(){
        when(personDao.savePerson(any(Person.class))).thenReturn(id);

        UUID uuid = personService.save(employer);

        assertNotNull(uuid);
    }

    @Test
    public void get() throws NotPersonException, PersonNotFoundException{
        when(personDao.getPerson(uuid.toString())).thenReturn(person);

        Person person = personService.get(uuid);

        assertNotNull(person);
    }





}
