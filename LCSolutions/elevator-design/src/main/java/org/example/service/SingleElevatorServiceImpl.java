package org.example.service;

import org.example.model.ComplexElevatorRequest;
import org.example.model.Direction;
import org.example.model.ElevatorRequest;

import java.util.Queue;
import java.util.TreeSet;

public class SingleElevatorServiceImpl {

    int currentFloor = 0;
    //Queue<ElevatorRequest> floorRequestQueue;
    Queue<ComplexElevatorRequest> complexElevatorRequests;

    //ElevatorRequest currentRequest = null;
    ComplexElevatorRequest currentComplexElevatorRequest = null;
    /*public SingleElevatorServiceImpl(Queue<ElevatorRequest> floorRequest){
        this.floorRequestQueue = floorRequest;
    }*/

    /*public SingleElevatorServiceImpl(Queue<ElevatorRequest> floorRequest, Queue<ComplexElevatorRequest> complexElevatorRequests){
        this.complexElevatorRequests = complexElevatorRequests;
        this.floorRequestQueue = floorRequest;
    }*/

    public SingleElevatorServiceImpl(Queue<ComplexElevatorRequest> complexElevatorRequests){
        this.complexElevatorRequests = complexElevatorRequests;
    }

    // simple use case
    /*public void pressFloor(int floor, Direction direction) throws InterruptedException {
        var request = new ElevatorRequest(direction, floor);
        floorRequestQueue.add(request);
    }*/

    /*public void processFloor() throws InterruptedException {
        while (true){
            while (!floorRequestQueue.isEmpty()){
                ElevatorRequest floorRequest = floorRequestQueue.poll();
                currentRequest = floorRequest;
                int floor = floorRequest.floor();
                Direction direction = floorRequest.direction();

                if(floor < 0 || floor > 10){
                    System.out.println("cannot start the lift");
                }
                if(direction == Direction.UP && currentFloor < floor){
                    System.out.println("lift started up, current floor: " + currentFloor);
                    startLift(floorRequest);
                    System.out.println("lift went up, final floor: " + currentFloor);
                } else if (direction == Direction.DOWN || currentFloor > floor) {
                    System.out.println("lift started down, current floor: " + currentFloor);
                    startLift(floorRequest);
                    System.out.println("lift went down, final floor: " + currentFloor);
                }
            }
        }
    }*/

    public void pressFloor(int startFloor, int endFloor, Direction direction) throws InterruptedException {
        var request = new ComplexElevatorRequest(direction, startFloor, endFloor);
        if(direction == Direction.UP && direction == currentComplexElevatorRequest.direction()
                && currentComplexElevatorRequest.startfloor() < startFloor
                && currentComplexElevatorRequest.endFloor() > endFloor){

        }
        complexElevatorRequests.add(request);
    }

    // use case with in between stops
    /*public void pressFloorWithInBetweenFloors(int floor, Direction direction) throws InterruptedException {
        while (true){
            while (!floorRequestQueue.isEmpty()){
                ElevatorRequest floorRequest = floorRequestQueue.poll();
                currentRequest = floorRequest;
                int floor = floorRequest.floor();
                Direction direction = floorRequest.direction();

                if(floor < 0 || floor > 10){
                    System.out.println("cannot start the lift");
                }
                if(direction == Direction.UP && currentFloor < floor){
                    System.out.println("lift started up, current floor: " + currentFloor);
                    startLift(floorRequest);
                    System.out.println("lift went up, final floor: " + currentFloor);
                } else if (direction == Direction.DOWN || currentFloor > floor) {
                    System.out.println("lift started down, current floor: " + currentFloor);
                    startLift(floorRequest);
                    System.out.println("lift went down, final floor: " + currentFloor);
                }
            }
        }
    }

    private void startLift(ElevatorRequest request) throws InterruptedException {
        int travelDiff = Math.abs(currentFloor - request.floor());
        while (travelDiff != 0){
            Thread.sleep(1000);
            travelDiff--;
        }
        currentFloor = request.floor();
    }










    private Direction currentDirection = Direction.UP;
    private State currentState = State.IDLE;
    private int currentFloor = 0;

    *//**
     * jobs which are being processed
     *//*
    private TreeSet<Request> currentJobs = new TreeSet<>();
    *//**
     * up jobs which cannot be processed now so put in pending queue
     *//*
    private TreeSet<Request> upPendingJobs = new TreeSet<>();
    *//**
     * down jobs which cannot be processed now so put in pending queue
     *//*
    private TreeSet<Request> downPendingJobs = new TreeSet<>();

    public void startElevator() {
        while (true) {

            if (checkIfJob()) {

                if (currentDirection == Direction.UP) {
                    Request request = currentJobs.pollFirst();
                    processUpRequest(request);
                    if (currentJobs.isEmpty()) {
                        addPendingDownJobsToCurrentJobs();

                    }

                }
                if (currentDirection == Direction.DOWN) {
                    Request request = currentJobs.pollLast();
                    processDownRequest(request);
                    if (currentJobs.isEmpty()) {
                        addPendingUpJobsToCurrentJobs();
                    }

                }
            }
        }
    }

    public boolean checkIfJob() {

        if (currentJobs.isEmpty()) {
            return false;
        }
        return true;

    }

    private void processUpRequest(Request request) {
        // The elevator is not on the floor where the person has requested it i.e. source floor. So first bring it there.
        int startFloor = currentFloor;
        if (startFloor < request.getExternalRequest().getSourceFloor()) {
            for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("We have reached floor -- " + i);
                currentFloor = i;
            }
        }
        // The elevator is now on the floor where the person has requested it i.e. source floor. User can enter and go to the destination floor.
        System.out.println("Reached Source Floor--opening door");

        startFloor = currentFloor;

        for (int i = startFloor; i <= request.getInternalRequest().getDestinationFloor(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("We have reached floor -- " + i);
            currentFloor = i;
            if (checkIfNewJobCanBeProcessed(request)) {
                break;
            }
        }

    }

    private void processDownRequest(Request request) {

        int startFloor = currentFloor;
        if (startFloor < request.getExternalRequest().getSourceFloor()) {
            for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("We have reached floor -- " + i);
                currentFloor = i;
            }
        }

        System.out.println("Reached Source Floor--opening door");

        startFloor = currentFloor;

        for (int i = startFloor; i >= request.getInternalRequest().getDestinationFloor(); i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("We have reached floor -- " + i);
            currentFloor = i;
            if (checkIfNewJobCanBeProcessed(request)) {
                break;
            }
        }

    }

    private boolean checkIfNewJobCanBeProcessed(Request currentRequest) {
        if (checkIfJob()) {
            if (currentDirection == Direction.UP) {
                Request request = currentJobs.pollFirst();
                if (request.getInternalRequest().getDestinationFloor() < currentRequest.getInternalRequest()
                        .getDestinationFloor()) {
                    currentJobs.add(request);
                    currentJobs.add(currentRequest);
                    return true;
                }
                currentJobs.add(request);

            }

            if (currentDirection == Direction.DOWN) {
                Request request = currentJobs.pollLast();
                if (request.getInternalRequest().getDestinationFloor() > currentRequest.getInternalRequest()
                        .getDestinationFloor()) {
                    currentJobs.add(request);
                    currentJobs.add(currentRequest);
                    return true;
                }
                currentJobs.add(request);

            }

        }
        return false;

    }

    private void addPendingDownJobsToCurrentJobs() {
        if (!downPendingJobs.isEmpty()) {
            currentJobs = downPendingJobs;
            currentDirection = Direction.DOWN;
        } else {
            currentState = State.IDLE;
        }

    }

    private void addPendingUpJobsToCurrentJobs() {
        if (!upPendingJobs.isEmpty()) {
            currentJobs = upPendingJobs;
            currentDirection = Direction.UP;
        } else {
            currentState = State.IDLE;
        }

    }


    public void addJob(Request request) {
        if (currentState == State.IDLE) {
            currentState = State.MOVING;
            currentDirection = request.getExternalRequest().getDirectionToGo();
            currentJobs.add(request);
        } else if (currentState == State.MOVING) {

            if (request.getExternalRequest().getDirectionToGo() != currentDirection) {
                addtoPendingJobs(request);
            } else if (request.getExternalRequest().getDirectionToGo() == currentDirection) {
                if (currentDirection == Direction.UP
                        && request.getInternalRequest().getDestinationFloor() < currentFloor) {
                    addtoPendingJobs(request);
                } else if (currentDirection == Direction.DOWN
                        && request.getInternalRequest().getDestinationFloor() > currentFloor) {
                    addtoPendingJobs(request);
                } else {
                    currentJobs.add(request);
                }

            }

        }

    }

    public void addtoPendingJobs(Request request) {
        if (request.getExternalRequest().getDirectionToGo() == Direction.UP) {
            System.out.println("Add to pending up jobs");
            upPendingJobs.add(request);
        } else {
            System.out.println("Add to pending down jobs");
            downPendingJobs.add(request);
        }
    }

    new Thread(new AddJobWorker(elevator, request1)).start();

		try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

}

class ProcessJobWorker implements Runnable {

    private Elevator elevator;

    ProcessJobWorker(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        *//**
         * start the elevator
         *//*
        elevator.startElevator();
    }

}*/
}
