package com.airlinemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    String id;
    OffsetDateTime dateTime;
    String source;
    String destination;
    @ManyToOne
    Flight flight;
}
