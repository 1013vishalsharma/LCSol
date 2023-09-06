package com.airlinemanagement.model;

//Ticket (List<Customer>, date, source, destination, List<Flight>)

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Table(name = "Ticket")
@Entity
public class Ticket {

    @Id
    String id;
    @Column
    String journeyDate;

    @Column
    String source;

    @Column
    String destinamtion;

    @ManyToMany
            @JoinTable(joinColumns = {
                    @JoinColumn(name = "fk_tickets")
            })
    List<Flight> flights;

    @ManyToMany
    List<Customer> customers;
}
