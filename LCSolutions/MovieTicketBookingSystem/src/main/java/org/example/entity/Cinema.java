package org.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class Cinema {

    String name;
    List<Hall> halls;
}
