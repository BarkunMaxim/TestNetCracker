package com.netcracker.edu.service;

import com.netcracker.edu.dto.Employer;
import com.netcracker.edu.entity.Person;

import java.util.UUID;

public interface PersonService {

    UUID save(Employer employer);

    Person get(UUID uuid);
}
