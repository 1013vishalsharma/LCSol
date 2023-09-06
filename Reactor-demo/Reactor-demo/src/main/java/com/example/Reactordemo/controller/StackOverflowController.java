package com.example.Reactordemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("test")
@Slf4j
public class StackOverflowController {

    @GetMapping
    public Mono<Void> testSO(){
        return Flux.fromIterable(Arrays.asList(1,2,3,4,5,6))
                .map(x -> {
                    try {
                        if(x > 6){
                            throw new IllegalArgumentException("value greater than 6");
                        }
                        return x*x*x;
                    } catch (IllegalArgumentException ex){
                        throw new RuntimeException("value greater than 6");
                    }
                })
                .flatMap(y -> {
                    try {
                        Thread.sleep(2000);
                        if(y%3 == 0) {
                            throw new IllegalArgumentException("value greater than 6");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return Mono.just(y);
                })
                .subscribeOn(Schedulers.boundedElastic())
                .map(x -> {
                    System.out.println(x);
                    return x;
                })
                .doOnError((err) -> {
                    System.err.println("Error occurred while processing: " + err.getMessage());
                })
                .then();
                //.blockLast();
    }

    List<MyEntity> myEntities = List.of(new MyEntity("1", "aa", 20),
            new MyEntity("2","bb", 10),
            new MyEntity("3","cc", 30),
            new MyEntity("4","dd", 40),
            new MyEntity("5","ee", 50),
            new MyEntity("6","ff", 60));
    List<SumEntity> sumEntities = new ArrayList();
    @GetMapping("mts2")
    public Mono<Void> testMts () throws InterruptedException {

        Flux<MyEntity> entities = findAll();


        return entities
                .doOnNext(record -> {
                    log.info("-------> came:: {}", record.id);
                    if (record.id.equals("3")) {
                        throw new RuntimeException("Deserialization Exception for id: " + record.id);
                    }
                })
                .doOnNext(System.out::println)
                .doOnError(throwable -> {
                    log.error("Received Exception: {}", throwable.getMessage());
                })
                .onErrorReturn(new MyEntity("10", "cc", 50))
                /*.onErrorContinue((err, obj) -> {
                    log.error("--<<< errored:: {}, and obj:: {}", err.getMessage(), obj);
                })*/
                /*.onErrorResume(throwable -> {
                    if (throwable instanceof RuntimeException) {
                        log.error("--<<< errored:: {}", throwable.getMessage());
                    }
                    return Mono.empty();
                })*/
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_ERROR) {
                        System.exit(1);
                    }
                }).then();
    }

    public Flux<MyEntity> findAll() throws InterruptedException {
        System.out.println("Making Db call again to fetch eneties");
        Thread.sleep(2000);
        return Flux.fromIterable(myEntities);
        //return Flux.just(new MyEntity("1", "aa", 20), new MyEntity("2","bb", 10));
    }

    public SumEntity createSumEntity(int sum){
        return new SumEntity("3", "cc", sum);
    }

    public Mono<SumEntity> save(SumEntity sumEntity) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Making db call to save sum entity entries");
        sumEntities.add(sumEntity);
        return Mono.just(sumEntity);

    }

    public Mono<MyEntity> save(MyEntity myEntity) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Making db call to save My entity entries");
        return Mono.just(myEntity);

    }
}

@Getter
@Setter
@AllArgsConstructor
@Data
class MyEntity {

    String id;
    String name;
    int amount;
}

@Getter
@Setter
@AllArgsConstructor
class SumEntity {

    String id;
    String name;
    int amount;
}
