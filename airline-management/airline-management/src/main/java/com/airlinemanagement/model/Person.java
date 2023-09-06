package com.airlinemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Person {

    @Id
    String id;
    @Column
    String fname;
    @Column
    String lname;
}
