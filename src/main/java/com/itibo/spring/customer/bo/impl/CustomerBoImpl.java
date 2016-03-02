package com.itibo.spring.customer.bo.impl;

import com.itibo.spring.customer.bo.CustomerBo;
import com.itibo.spring.customer.dao.CustomerDao;
import com.itibo.spring.customer.model.Customer;

import java.util.List;

/**
 * Created by union on 02.03.2016.
 */

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }
}
