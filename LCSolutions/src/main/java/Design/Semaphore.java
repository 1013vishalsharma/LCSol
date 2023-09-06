package main.java.Design;

import java.util.Arrays;
import java.util.Random;

class Task extends Thread{

    volatile int[] semaphoreCount;
    public Task(int[] semaphoreCount){
        this.semaphoreCount = semaphoreCount;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (this){
            while(Arrays.stream(semaphoreCount).allMatch(x -> x==1)){
                try {
                    System.out.println("no semaphore available waiting..... " + currentThread().getName());
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(Arrays.stream(semaphoreCount).anyMatch(x -> x==0)){
                int idx = 0;
                for (int i =0; i<semaphoreCount.length; i++){
                    if(semaphoreCount[i] == 0){
                        idx = i;
                    }
                }
                semaphoreCount[idx] = 1;
                System.out.println("semaphore acquired: " + idx + " work done by: " + Thread.currentThread().getName());
                long sum = 0;
                for (int i=0; i< random.nextInt(10000000); i++){
                        sum += i;
                    }
                System.out.println(sum);
                semaphoreCount[idx] = 0;
                System.out.println("semaphore released: " + idx + " by: " + currentThread().getName());
                notifyAll();
            }
        }
    }
}
public class Semaphore {

    public static void main(String[] args) {
        int[] semaphoreCount = new int[3];

        for (int i= 0; i< 100; i++){
            new Task(semaphoreCount).start();
        }

        while(true){
            if(Arrays.stream(semaphoreCount).allMatch(x -> x==1)){
                System.out.println("all semaphores acquired....");
            }
        }
    }
}

// semaphore is n permit to access the resource
//  50 threads but only 3 will go ahead
