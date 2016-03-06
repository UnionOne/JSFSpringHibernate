package com.itibo.spring.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

/**
 * Created by union on 02.03.2016.
 */

@Entity
@Table(name = "PERSON")
@ManagedBean(name = "person")
public class Person {
    private int id;
    private String name;
    private String country;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}