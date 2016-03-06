package com.itibo.spring.service;

import com.itibo.spring.dao.PersonDao;
import com.itibo.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

@Service
@ManagedBean(name = "personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        this.personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        this.personDao.deletePerson(person);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPersons();
    }
}