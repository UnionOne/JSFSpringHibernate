package com.itibo.spring.customer.dao;

import com.itibo.spring.customer.model.Customer;

import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

public interface CustomerDao {
    void addCustomer(Customer customer);

    List<Customer> findAllCustomer();
}