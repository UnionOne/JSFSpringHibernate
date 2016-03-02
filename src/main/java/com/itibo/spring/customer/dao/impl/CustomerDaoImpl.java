package com.itibo.spring.customer.dao.impl;

import com.itibo.spring.customer.dao.CustomerDao;
import com.itibo.spring.customer.model.Customer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Date;
import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void addCustomer(Customer customer) {
        customer.setCreatedDate(new Date());
        getHibernateTemplate().save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return getHibernateTemplate().find("from Customer");
    }
}