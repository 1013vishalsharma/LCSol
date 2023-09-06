import com.google.common.util.concurrent.ThreadFactoryBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MTSample3 {

    public static void main(String[] args) throws InterruptedException {
        //computeFromCallable();
        //Thread.sleep(10000);
        System.out.println("----------------------------------------------------------------------------");
        //computeSequentially();
        testParallel();
    }

    private static void computeFromCallable() {
        for (int i = 0; i<200; i++){
            Mono<Integer> integerMono = Mono
                    .fromCallable(MTSample3::compute)
                    .subscribeOn(Schedulers.boundedElastic());
            integerMono
                    .subscribe((x) -> System.out.println("return value for thread: " + Thread.currentThread().getName() + " is: " + x));
        }
    }

    private static void computeSequentially() throws InterruptedException {
        for (int i = 0; i<200; i++){
            compute();
        }
    }

    static Random rand1 = new Random();
    private static int compute() throws InterruptedException {
        int i = rand1.nextInt(2000);
        int j = rand1.nextInt(10);
        System.out.println("sleep delay for thread: " + Thread.currentThread().getName() + " is: " + i);
        Thread.sleep(i);
        return j;
    }

    public static void testParallel() throws InterruptedException {
        ThreadPoolExecutor RANGE_SCHEDULER_POOL =
                new ThreadPoolExecutor(
                        3,
                        256,
                        30L,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(5),
                        new ThreadFactoryBuilder().setNameFormat("Range-Scheduler-%d").build(),
                        new ThreadPoolExecutor.CallerRunsPolicy()
                );

        RANGE_SCHEDULER_POOL.allowCoreThreadTimeOut(true);
        Scheduler RANGE_SCHEDULERS_POOL = Schedulers.fromExecutor(RANGE_SCHEDULER_POOL);

        ParallelFlux<String> parallelFlux = Flux
                .range(1, 500)
                .parallel(20)
                .runOn(RANGE_SCHEDULERS_POOL)
                .flatMap(index -> {
                    Mono<String> supplier = Mono.fromSupplier(() -> {
                        //        System.out.println("current index: " + index + "with thread: " + Thread.currentThread().getName());
                        Random random = new Random();
                        try {
                            //Thread.sleep(10000);
                            Thread.sleep(random.nextInt(1000));
                        } catch (InterruptedException e) {
                        }
                        return String.format("mono1-%s-%d%n", Thread.currentThread().getName(), index);
                    });
                            //.subscribeOn(RANGE_SCHEDULERS_POOL);
                    return supplier.map(obj -> obj);

                });
        Mono<List<String>> mono1 = parallelFlux
                .collectSortedList(Comparator.comparingInt(Object::hashCode));

        mono1.subscribe((x) -> {
            System.out.println("what is in the list: " + x);
        });

        Thread th = new Thread(() -> {
            while (true){
                System.out.println(RANGE_SCHEDULER_POOL);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        });
        th.start();
        Thread.sleep(60_000_000);
    }
}
