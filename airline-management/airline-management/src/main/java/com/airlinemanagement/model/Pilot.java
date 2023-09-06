package com.airlinemanagement.model;

public class Pilot extends Person{

    Flight flight;

    public Pilot(String id, String fname, String lname, Flight flight) {
        super(id, fname, lname);
        this.flight = flight;
    }
}
