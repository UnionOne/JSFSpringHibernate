package com.itibo.spring.dao;

import com.itibo.spring.model.Person;

import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

public interface PersonDao {
    void addPerson(Person person);

    void deletePerson(Person person);

    List<Person> listPersons();
}