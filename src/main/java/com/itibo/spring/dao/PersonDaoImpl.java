package com.itibo.spring.dao;

import com.itibo.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

@Repository
public class PersonDaoImpl implements PersonDao {
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        logger.info("Person saved successfully, Person details: " + person.toString());
    }

    @Override
    public void deletePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(person);
        logger.info("Person delete successfully, Person details: " + person.toString());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();
        for (Person person : personList) {
            logger.info("Person List::" + person.toString());
        }
        return personList;
    }
}
