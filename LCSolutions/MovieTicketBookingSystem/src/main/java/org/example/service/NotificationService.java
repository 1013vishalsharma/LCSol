package org.example.service;

import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    List<User> observers = new ArrayList<>();

    public void register(User user){
        observers.add(user);
    }

    public void deregister(User user1){
        for (User user: observers){
            if(user.getFname().equals(user1.getFname()) && user.getLname().equals(user1.getLname())){
                observers.remove(user);
            }
        }
    }

    public void notifyUser(){
        for (User user: observers){
            int num = user.getMobileNo();
            System.out.println("sending sms about new movie to num: " + num);
        }
    }
}
