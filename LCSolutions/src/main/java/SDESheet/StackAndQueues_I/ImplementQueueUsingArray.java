package SDESheet.StackAndQueues_I;

import java.util.Arrays;

public class ImplementQueueUsingArray {

    int front, rear, size;
    int[] queue;
    public ImplementQueueUsingArray(int maxSize){
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull(){
        return size == queue.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int data) {
        if(isFull()){
            System.out.println("Cannot enqueue next element as queue is full");
            return;
        }
        rear = (rear+1) % queue.length;
        queue[rear] = data;
        size++;
        System.out.println("element successfully queued: "+ Arrays.toString(queue) + " front: " + front + " rear: " + rear + " size: " + size);
    }

    public void dequeue() {
        if(isEmpty()){
            System.out.println("Cannot dequeue as queue is empty");
            return;
        }
        queue[front] = 0;
        front = (front+1) % queue.length;
        size--;
        System.out.println("element successfully dequeued: " + Arrays.toString(queue) + " front: " + front + " rear: " + rear);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Cannot peek element as queue is empty: " + Arrays.toString(queue));
            return -1;
        }
        System.out.println("Front element is: " + queue[front]  + " front: " + front + " rear: " + rear);
        return queue[front];
    }

    public static void main(String[] args) {
        ImplementQueueUsingArray queue = new ImplementQueueUsingArray(3);

        System.out.println("here: " + 6%5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.peek();
        queue.enqueue(3);
        System.out.println(queue.isFull() + " front: " + queue.front + " rear: " + queue.rear);
        queue.enqueue(4);
        queue.dequeue();
        System.out.println(queue.isFull() + " front: " + queue.front + " rear: " + queue.rear);
        queue.peek();
        queue.dequeue();
        System.out.println(queue.isEmpty() + " front: " + queue.front + " rear: " + queue.rear);
        queue.enqueue(5);
        queue.peek();
        queue.dequeue();
        System.out.println(queue.isEmpty() + " front: " + queue.front + " rear: " + queue.rear);
        queue.peek();
        queue.dequeue();
        queue.peek();
        queue.enqueue(6);
        System.out.println(queue.isEmpty() + " front: " + queue.front + " rear: " + queue.rear);
        System.out.println(queue.isFull() + " front: " + queue.front + " rear: " + queue.rear);
        queue.peek();
        queue.enqueue(7);
        queue.peek();
        queue.enqueue(8);
        System.out.println(queue.isFull() + " front: " + queue.front + " rear: " + queue.rear);
        queue.peek();
        queue.dequeue();
        queue.peek();

    }
}
