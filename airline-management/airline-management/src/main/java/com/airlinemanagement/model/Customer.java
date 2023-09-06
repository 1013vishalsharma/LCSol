package com.airlinemanagement.model;

import jakarta.persistence.Entity;

@Entity(name = "Customer")
public class Customer extends Person{
    public Customer(String id, String fname, String lname) {
        super(id, fname, lname);
    }
}
