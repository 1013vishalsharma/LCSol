package org.example.service;

import org.example.entity.PaymentType;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookingService {

    boolean[][] seats;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock;
    Lock writeLock;
    int count;
    PaymentService paymentService;
    public BookingService(int rows, int cols){
        seats = new boolean[rows][cols];
        count = 0;
        paymentService = new PaymentService();
    }

    public void showAllSeats(){
        readLock = readWriteLock.readLock();

        try {
            readLock.lock();
            for (int i = 0; i < seats.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ ");
                for (int j = 0; j < seats[0].length; j++) {
                    if (seats[i][j]) {
                        sb.append("X ");
                    } else {
                        sb.append(". ");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        } finally {
            readLock.unlock();
        }
    }

    public void bookSingleSeat(int row, int col){
        writeLock = readWriteLock.writeLock();
        try {
            writeLock.lock();
            if (validateIfSeatIsEmpty(row, col)) {
                System.out.println("Seats in row:" + row + " col:" + col + " is not available, count:" + count);
            } else {
                seats[row][col] = true;
                count++;
                System.out.println("Seat in row:" + row + " col:" + col + " is booked successfully, count:" + count);
            }

            if(count > seats.length * seats[0].length){
                System.out.println("Error: Hall is over booked!!!!!!");
            }
            paymentService.payForTickets(10, PaymentType.CASH);
        } finally {
            writeLock.unlock();
        }
    }

    private boolean validateIfSeatIsEmpty(int row, int col){
        return seats[row][col];
    }
}
