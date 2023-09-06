package com.example.Reactordemo;

import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class TryStackOverflow {

    public static void main(String[] args) {


        /*Flux.fromIterable(Arrays.asList(1,2,3,4,5,6))
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
                        if(y%13 == 0) {
                            throw new IllegalArgumentException("value greater than 6");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return Flux.just(y);
                })
                .doOnError((err) -> {
                    System.err.println("Error occurred while processing: " + err.getMessage());
                })
                .blockLast();*/
                //.subscribe(System.out::println);
    }

    /*public Mono<List<ResponseTo>> getItemDetails(RequestTo itemRequest) {
        return itemRequest
                .itemIdList
                .toFlux()
                .flatMap ( findItemStatus(it) )
        .flatMap {
            response ->
                    Mono.justOrEmpty(ResponseTo(response))
                            .onErrorResume {
                logger.error("Error occurred while mapping entity to response: $response", it)
                Mono.empty()
            }
        }
        .collectList()
    }

    @Getter
    class ResponseTo {
        public List<String> itemIdList = List.of("abc", "def", "xyz", "mnb");
    }*/
}
