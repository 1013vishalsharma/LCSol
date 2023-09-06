package org.example.service;

import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users;
    private NotificationService notificationService;
    public UserService(){
        users = new ArrayList<>();
        notificationService = new NotificationService();
    }

    public void createUser(String fname, String lname){
        User user = new User(fname, lname, 987654321);
        users.add(user);
        notificationService.register(user);
    }

    public void deleteUser(String fname, String lname){
        for (User user: users){
            if(user.getFname().equals(fname) && user.getLname().equals(lname)){
                notificationService.deregister(user);
                users.remove(user);
            }
        }

    }
}
