package main.java.Design;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

class Producer extends Thread{
    private LinkedList<Integer> queue;
    int size;
    public Producer(LinkedList<Integer> queue, int size){
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                if(queue.size() == size){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //while (queue.size() != size) {
                Random rand = new Random();
                int x = rand.nextInt();
                System.out.println("added: " + x);
                queue.add(x);
                queue.notifyAll();
                System.out.println("size: " + queue.size() + " " + Thread.currentThread().getName());
                //}
            }
        }
    }
}

class Consumer extends Thread{
    private LinkedList<Integer> queue;
    int size;
    public Consumer(LinkedList<Integer> queue, int size){
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while(true) {
            //while (!queue.isEmpty()) {
            synchronized (queue) {
                if(queue.isEmpty()){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("removed: " + queue.remove());
                System.out.println("size: " + queue.size() + " " + Thread.currentThread().getName());
                //}
                queue.notifyAll();
            }
        }
    }
}

class BlockingProducer extends Thread{

    private ArrayBlockingQueue<Integer> queue;
    public BlockingProducer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }

    Random rand = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                int x = rand.nextInt();
                queue.put(x);
                System.out.println("added: " + x);
            }
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

class BlockingConsumer extends Thread{

    private ArrayBlockingQueue<Integer> queue;
    public BlockingConsumer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("removed: " + queue.take());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        /*LinkedList<Integer> queue = new LinkedList<>();
        new Producer(queue, 100).start();
        new Consumer(queue, 100).start();
        new Consumer(queue, 100).start();*/

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        new BlockingProducer(arrayBlockingQueue).start();
        new BlockingConsumer(arrayBlockingQueue).start();
    }
}
