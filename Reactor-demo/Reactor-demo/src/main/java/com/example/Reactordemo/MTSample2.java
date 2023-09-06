package com.example.Reactordemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MTSample2 {



    public static void main(String[] args) throws InterruptedException {
        var mono1 = Mono.just(1);

        var mono2 = Mono.just(2);

        var mono3 = Mono.empty();

        var zip = Mono.zip(mono1, mono2, mono3)
                .subscribe(x -> System.out.println(x + " "));

        mono1.map(x -> List.of(4,5,6,7))
                .doOnNext(System.out::println)
                .flatMap(MTSample2::processX)
                .onErrorResume(throwable -> handleAndReturnEmpty(throwable, mono1))
                .subscribe();
    }


    private static Mono processX(List<Integer> ints){
        if(ints.contains(4)){
            return Mono.error(new NullPointerException("4 == null"));
        } else {
            return Mono.just(5);
        }
    }

    private static Mono handleAndReturnEmpty(Object cause, Mono<Integer> mono1) {
        return mono1
                .doOnNext(info -> System.err.println(cause))
                .flatMap(Mono::just)
                .flatMap(info -> Mono.empty());
    }
}