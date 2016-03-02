package com.itibo.spring.customer.model;

import java.util.Date;

/**
 * Created by union on 02.03.2016.
 */

public class Customer {
    public long customerId;
    public String name;
    public String address;
    public Date createdDate;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addred) {
        this.address = addred;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}