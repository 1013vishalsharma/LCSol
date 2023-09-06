package main.java.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

class CTETask implements Callable<Integer>{

    int i;
    Random rand;
    public CTETask(int i, Random rand){
        this.i = i;
        this.rand = rand;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("executing task: " + i + " with thread: " + Thread.currentThread().getName());
        Thread.sleep(rand.nextInt(500));
        return 0;
    }
}

public class CustomThreadPool {
    private BlockingQueue<CTETask> queue;
    private int threadPoolCount;
    private boolean startThreadPool = false;

    private List<Thread> threads = new ArrayList<>(10);
    public CustomThreadPool(BlockingQueue<CTETask> queue, int threadPoolCount) {
        this.queue = queue;
        this.threadPoolCount = threadPoolCount;
        for (int i=0; i<threadPoolCount; i++){
            threads.add(new Thread(new Worker()));
        }
    }

    public void submitTasks(CTETask task){
        queue.add(task);
    }

    public void startThreadPool() throws InterruptedException {
        startThreadPool = true;
        threads.forEach(Thread::start);
    }

    public void shutDownThreadPool(){
        startThreadPool = false;
    }

    class Worker implements Runnable{

        @Override
        public void run() {
            while (startThreadPool){
                try {
                    queue.take().call();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool threadPool = new CustomThreadPool(new LinkedBlockingQueue<>(), 10);
        threadPool.startThreadPool();
        Random rand = new Random();
        for (int i = 0; i< 10000; i++){
            threadPool.submitTasks(new CTETask(i, rand));
        }
        Thread.sleep(10000);
        threadPool.shutDownThreadPool();
    }
}
