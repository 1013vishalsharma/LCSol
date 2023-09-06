package com.airlinemanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookService {

    @Autowired
    AirlineService airlineService;

    public void ticket(){
        System.out.println("ticketBooked");
    }
}
