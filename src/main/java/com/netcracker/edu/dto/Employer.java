package com.netcracker.edu.dto;

import lombok.Data;

@Data
public class Employer {
    private String name;

    private String surname;

    private int age;

    public Employer(){

    }
    public Employer(String name, byte age) {
        this.name = name;
        this.age = age;
    }
}
