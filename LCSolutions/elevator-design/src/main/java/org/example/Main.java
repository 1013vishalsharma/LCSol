package org.example;

//import org.example.model.ComplexElevatorRequest;
import org.example.model.Direction;
import org.example.service.SingleElevatorServiceImpl;
import org.example.service.SingleElevatorWithComplexDesign;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        /*Queue<ElevatorRequest> request = new LinkedList<>();
        SingleElevatorServiceImpl service = new SingleElevatorServiceImpl(request);
        new Thread(() -> {
            try {
                System.out.println("starting lift....");
                service.processFloor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        service.pressFloor(5, Direction.UP);
        service.pressFloor(7, Direction.UP);
        service.pressFloor(2, Direction.DOWN);
        service.pressFloor(0, Direction.DOWN);
        service.pressFloor(8, Direction.UP);
        service.pressFloor(5,Direction.DOWN);*/

        SingleElevatorWithComplexDesign service = new SingleElevatorWithComplexDesign();
        new Thread(() -> {
            try {
                service.processRequest();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        /*service.addNewJob(new ComplexElevatorRequest(Direction.UP, 0, 10));
        service.addNewJob(new ComplexElevatorRequest(Direction.UP, 3, 5));
        service.addNewJob(new ComplexElevatorRequest(Direction.UP,7,9 ));
        Thread.sleep(7000);
        service.addNewJob(new ComplexElevatorRequest(Direction.UP, 2,4));*/
    }
}