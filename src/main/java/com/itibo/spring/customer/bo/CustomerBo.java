package com.itibo.spring.customer.bo;

import com.itibo.spring.customer.model.Customer;

import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

public interface CustomerBo {
    void addCustomer(Customer customer);

    List<Customer> findAllCustomer();
}