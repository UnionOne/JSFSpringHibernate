package com.itibo.spring.service;

import com.itibo.spring.model.Person;

import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

public interface PersonService {
    void addPerson(Person person);

    public List<Person> listPersons();
}