package com.example.Reactordemo;

import java.io.IOException;
import java.util.concurrent.*;

public class MTSample {

    public static void main(String[] args) throws ClassNotFoundException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("here i am ");
                try {
                    throw new IOException("null pointer agaya");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        //new Thread(runnable).start();


        Callable<Void> callable = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.println("inside callable");
                throw new IOException("io exception agaya in callable");
            }
        };
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Void> future = es.submit(callable);
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println("Interrupted m aya");
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("Execution exception m aya");
            throw new RuntimeException(e);
        }
    }
    }
