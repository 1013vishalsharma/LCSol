package org.example.service;

import org.example.model.Car;
import org.example.model.Position;
import org.example.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceImpl {

    List<Slot[][]> parkingLot;

    public ParkingLotServiceImpl(List<Slot[][]> parkingLot){
        this.parkingLot = parkingLot;
    }

    public void getParkingSlot(Car car){
        Slot freeSlot = getAvailableSlot();
        if(freeSlot == null){
            throw new RuntimeException("no free slot available");
        }
        freeSlot = new Slot(car);
    }

    private Position getAvailableSlot(){
        for (Slot[][] slot: parkingLot){
            for (int i=0;i<slot.length;i++){
                for (int j=0; j<slot[0].length; j++){
                    if(slot[i][j] == null){
                        return new Position(0, i, j);
                    }
                }
            }
        }
        return null;
    }
}
