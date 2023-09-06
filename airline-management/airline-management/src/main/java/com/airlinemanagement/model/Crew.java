package com.airlinemanagement.model;

public class Crew extends Person{

    Flight flight;
    public Crew(String id, String fname, String lname, Flight flight) {
        super(id, fname, lname);
        this.flight = flight;
    }
}
