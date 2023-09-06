package com.example.Reactordemo.FluxSample;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.function.Predicate.not;

public class FluxSample {

    public static void main(String[] args) throws InterruptedException {

        Flux.just("here", "i", "am")
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();

        List<String> li = Arrays.asList("reactor", "seems", "cool", "now");
        Flux.fromIterable(li)
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();

        Flux.fromArray(new Integer[]{1,2,3,4})
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();

        Flux.empty()
                .log()
                .subscribe();
        System.out.println();

        Mono.empty()
                .log()
                .subscribe();
        System.out.println();

        Flux.range(5,3)
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();

        Mono.just(new Integer[]{1,2,3,4,5})
                .subscribe(x -> System.out.print(Arrays.toString(x) + " "));
        System.out.println();

        Disposable subscribe = Flux.interval(Duration.ofMillis(10))
                .subscribe(x -> System.out.print(x + " "));
        Thread.sleep(2000);
        subscribe.dispose();
        System.out.println();

        /*Flux.interval(Duration.ofMillis(105))
                .flatMap(x ->Mono.just(x).delayElement(Duration.ofMillis(5)), 10)
                .subscribe(x -> System.out.print(x + " "));

        Thread.sleep(3000);
        subscribe.dispose();
        System.out.println();*/

        /*Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
        System.out.println("out side publish on thread is " + Thread.currentThread().getName());
        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> {
                    System.out.println("in map 1 current thread is: " + Thread.currentThread().getName());
                    return 10 + i;
                })
                .publishOn(s)
                .map(i -> {
                    System.out.println("in map 2 current thread is: " + Thread.currentThread().getName());
                    return "value " + i;
                });

        new Thread(() -> flux.subscribe(x -> {
            System.out.println("current thread is: " + Thread.currentThread().getName());
            System.out.println(x + " Thread is "+ Thread.currentThread().getName());
        })).start();
        System.out.println();*/

        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
        System.out.println("out side publish on thread is " + Thread.currentThread().getName());

        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> {
                    System.out.println("in map 1 current thread is: " + Thread.currentThread().getName());
                    return 10 + i;
                })
                .subscribeOn(s)
                .map(i -> {
                    System.out.println("in map 2 current thread is: " + Thread.currentThread().getName());
                    return "value " + i;
                });

        new Thread(() -> flux.subscribe(x -> {
            System.out.println("current thread is: " + Thread.currentThread().getName());
            System.out.println(x + " Thread is "+ Thread.currentThread().getName());
        })).start();
        System.out.println();


        Thread.sleep(1000);
        System.out.println("-------------------------------------------------------");
        Mono<String> mono = Mono.just("first").doOnNext(a -> System.out.println(a + " was called."));

        Mono<String> mono2 = Mono.<String>error(new RuntimeException("Not terminating error."))
                .onErrorResume(not(ShortCircuitingException.class::isInstance), e -> Mono.empty());

        Mono<String> mono3 = Mono.just("third").doOnNext(a -> System.out.println(a + " was called."));

        Mono<String> mono4 = Mono.<String>error(new ShortCircuitingException())
                .onErrorResume(not(ShortCircuitingException.class::isInstance), e -> Mono.empty());

        Mono<String> mono5 = Mono.just("fifth").doOnNext(a -> System.out.println(a + " was called."));

        Flux.concatDelayError(mono, mono2, mono3, mono4, mono5)
                .collectList()
                .subscribe();


        System.out.println("-----------------------------------------------------------------------");
        System.out.println("---------------------------------trying mono zip function--------------------------------");
        Mono<String> zip1 = Mono.just("first");
                //.doOnNext(a -> System.out.println(a + " was called."));

        Mono<String> zip2 = Mono.<String>error(new RuntimeException("Not terminating error."));
                //.onErrorResume(not(ShortCircuitingException.class::isInstance)
                        //, e -> Mono.just("second error")
                        //.doOnNext(a -> System.out.println(a + " was called")));

        Mono<String> zip3 = Mono.just("third");
                //.doOnNext(a -> System.out.println(a + " was called."));

        Mono<String> zip4 = Mono.error(new IllegalArgumentException("illegal arguments"));

        List<String> ans = new ArrayList<>();
        Flux.just(List.of(zip1, zip2, zip3, zip4))
                        .flatMap(Flux::fromIterable,
                                (err) -> {
                                    System.out.println("error is");
                            return Mono.empty();
                                }, null)
                .map(x -> {
                    System.out.println(x);
                    return x;
                })
                                .subscribe(System.out::println);

        /*Mono.zipDelayError(zip1, zip2, zip3, zip4)
                .onErrorContinue((err, o) -> {
                    System.out.println(o);
                })
                .doOnSuccess(x -> System.out.println(" in do on suceess x"))
                .map(x -> {
                    System.out.println("in map error");
                    return x;
                })
                .subscribe();*/


    }
}

class ShortCircuitingException extends Exception{

    public ShortCircuitingException(){
        super("error occurred");
    }
}
