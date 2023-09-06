package org.example.model;

import lombok.Data;

public record ElevatorRequest(Direction direction, int floor) {

}
