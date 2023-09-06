package com.example.Reactordemo.FluxSample;

import reactor.core.publisher.Flux;

public class PeekingIntoASequence {

    public static void main(String[] args) {

        Flux.just(1,2,3,4,5)
                .doOnNext(x -> System.out.print(x + " "))
                .subscribe();

        System.out.println();
        System.out.println("--------------------------------------------------------");

        Flux.just(1,2,3,4,5)
                .doOnNext(x -> System.out.print(x + " "))
                .doOnComplete(() -> System.out.print("all elements have been emiteed from flux"))
                .subscribe();

        System.out.println();
        System.out.println("--------------------------------------------------------");

        Flux.just(1,2,3,4,5)
                .doOnNext(x -> System.out.print(x + " "))
                .doOnNext(x -> {
                    if (x ==4){
                        throw new IllegalArgumentException(" error in flux");
                    }
                })
                .doOnError(err -> System.out.println("error occurred " + err.getMessage()))
                .doOnComplete(() -> System.out.print("all elements have been emiteed from flux"))
                .subscribe();

        System.out.println();
        System.out.println("--------------------------------------------------------");

        Flux.just(1,2,3,4,5)
                .doOnNext(x -> System.out.print(x + " "))
                .doOnSubscribe(sub -> {
                    System.out.println(sub);
                })
                .subscribe();

        System.out.println();
        System.out.println("--------------------------------------------------------");

        Runnable run = new Runnable() {
            @Override
            public void run() {

            }
        };

        new Object(){
            void name(){
                System.out.println();
            }
        };
    }
}
