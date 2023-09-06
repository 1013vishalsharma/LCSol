package org.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class Hall {

    String name;
    List<Slot> slots;
}
