package org.example.service;

import org.example.model.ComplexElevatorRequest;
import org.example.model.Direction;

import java.util.Comparator;
import java.util.TreeSet;

public class SingleElevatorWithComplexDesign {

    TreeSet<ComplexElevatorRequest> currentJobs = new TreeSet<>(
            Comparator.comparingInt(ComplexElevatorRequest::endFloor)
    );

    TreeSet<ComplexElevatorRequest> upJobs = new TreeSet<>(
            Comparator.comparingInt(ComplexElevatorRequest::endFloor)
    );

    TreeSet<ComplexElevatorRequest> downJobs = new TreeSet<>(
            Comparator.comparingInt(ComplexElevatorRequest::endFloor)
    );

    Direction currentDirection = Direction.UP;
    int currentFloor = 0;

    public SingleElevatorWithComplexDesign(){

    }

    public void addNewJob(ComplexElevatorRequest request){
        if(request.direction() != currentDirection && request.direction() == Direction.UP){
            upJobs.add(request);
        } else if(request.direction() != currentDirection && request.direction() == Direction.DOWN){
            downJobs.add(request);
        } else if (request.direction() == currentDirection) {
            if (request.direction() == Direction.UP && request.endFloor() < currentFloor){
                upJobs.add(request);
            } else if (request.direction() == Direction.DOWN && request.endFloor() > currentFloor) {
                downJobs.add(request);
            }
            currentJobs.add(request);
        }
    }

    public void processRequest() throws InterruptedException {
        while (true){
            if(!currentJobs.isEmpty()){
                if(currentDirection == Direction.UP){
                    processUpJobs();
                } else {
                    processDownJobs();
                }
            }
        }
    }

    public void processUpJobs() throws InterruptedException {
        ComplexElevatorRequest request = currentJobs.pollFirst();
        if(currentFloor < request.startfloor()){
            for (int i=currentFloor; i<=request.startfloor(); i++){
                System.out.println(" " + i);
                Thread.sleep(1000);
            }
            currentFloor = request.startfloor();
            System.out.println("reached start floor: " + currentFloor + " Doors opening...");
        } else if (request.startfloor() < currentFloor) {
            System.out.println("already passed start floor: " + request.startfloor());
        }
        int startFloor = currentFloor;
        System.out.println("going up and current floor ");
        for (int i = currentFloor; i<=request.endFloor(); i++){
            System.out.println(" " + i);
            Thread.sleep(1000);
            startFloor = i;
            if(checkAndAddExistingRequests(request)){
                break;
            }
        }
        if(startFloor == request.endFloor())
            System.out.println("reached end floor: "+ startFloor +" Doors opening...");
        currentFloor = startFloor;
    }

    public void processDownJobs() throws InterruptedException {
        ComplexElevatorRequest request = currentJobs.pollFirst();
        if(currentFloor < request.startfloor()){
            System.out.println("Elevator currently on floor: " + currentFloor);
            System.out.println("Elevator is going up");
            for (int i=currentFloor; i<=request.startfloor(); i++){
                System.out.println("Elevator going up and current floor is: " + i);
                Thread.sleep(1000);
            }
            currentFloor = request.startfloor();
        }
        int startFloor = currentFloor;
        for (int i = currentFloor; i>=request.endFloor(); i--){
            System.out.println("Elevator going up and current floor is: " + i);
            Thread.sleep(1000);
            startFloor = i;
            if(checkAndAddExistingRequests(request)){
                break;
            }
        }
        currentFloor = startFloor;
    }

    private boolean checkAndAddExistingRequests(ComplexElevatorRequest currentRequest){
        if(!currentJobs.isEmpty()) {
            ComplexElevatorRequest upcomingRequest = currentJobs.pollFirst();
            if (upcomingRequest.direction() == currentRequest.direction() && upcomingRequest.direction() == Direction.UP
                    && upcomingRequest.endFloor() < currentFloor) {
                currentJobs.add(upcomingRequest);
                currentJobs.add(currentRequest);
                System.out.println("added new request processing from floor: "
                        + upcomingRequest.startfloor() + " to floor: "+ upcomingRequest.endFloor());
                return true;
            } else {
                currentJobs.add(upcomingRequest);
            }

            if (upcomingRequest.direction() == currentRequest.direction() && upcomingRequest.direction() == Direction.DOWN
                    && upcomingRequest.endFloor() > currentFloor) {
                currentJobs.add(upcomingRequest);
                currentJobs.add(currentRequest);
                return true;
            } else {
                currentJobs.add(upcomingRequest);
            }
        }
        return false;
    }
}
