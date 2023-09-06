package com.example.Reactordemo.FluxSample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransformingASequence {
    public static void main(String[] args) {

        // Map elements----------------------------
        Mono.just("This is what a mono transformation looks like in real!!!")
                .map(str -> Arrays
                        .stream(str.split(" "))
                        .map(String::length)
                )
                .subscribe(a -> a
                        .forEach(b -> System.out.print(b + " "))
                );
        System.out.println();
        System.out.println("---------------------------------------------");

        String str = "This is what a flux transformation looks like in real!!!";
        Flux.fromStream(Arrays
                .stream(str.split(" "))
        )
                .map(String::length)
                .subscribe(b -> System.out.print(b + " "));
        System.out.println();
        System.out.println("---------------------------------------------");


        // Cast elements in flux or mono--------------
        Flux.fromStream(Arrays
                .stream(str.split(" "))
        )
                .map(String::length)
                .cast(Number.class)
                .subscribe(b -> System.out.print(b + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        Mono.just(1)
                .cast(Object.class)
                .subscribe(b -> System.out.print(b + " "));
        System.out.println();
        System.out.println("---------------------------------------------");


        // index elements in a flux
        Flux
                .fromStream(Arrays
                    .stream(str.split(" ")))
                .index()
                .subscribe(x -> System.out.print("(" + x.getT1() + ", " + x.getT2() + ")" + ", "));
        System.out.println();
        System.out.println("---------------------------------------------");

        // zip on a flux element
        Flux
                .zip(Flux.range(1,10),
                        Flux.range(100,20),
                        Flux.range(200, 30))
                .subscribe(x -> System.out.print(x + " "));
                //.subscribe(x -> System.out.print("(" + x.getT1() + ", " + x.getT2() + ")" + ", "));

        System.out.println();
        System.out.println("---------------------------------------------");

        // combine latest on flux
        Flux
                .combineLatest(Flux.range(1,10),
                        Flux.range(100,20),
                        Flux.range(200, 30),
                        (arr) -> {
                            //System.out.println(("value of arr is: "+arr));
                    return Arrays
                                    .stream(arr)
                                    .mapToInt(x -> (int)x)
                                    .sum();
                        })
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");


        Flux
                .combineLatest(
                        ((arr) -> {
                            //System.out.println(("value of arr is: "+arr));
                            return Arrays
                                    .stream(arr)
                                    .mapToInt(x -> (int)x)
                                    .sum();
                        }), Flux.range(1,10),
                        Flux.range(100,20),
                        Flux.range(200, 30))
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");


        // firstWithvalue on Flux

        Flux.firstWithValue(
                Flux.error(new IllegalArgumentException("illegal argument")),
                        Flux.empty(),
                        Flux.range(2,10),
                        Flux.range(10, 100)
        ).subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");


        // firstWithSignal on flux

        Flux.firstWithSignal(
                Flux.error(new IllegalArgumentException("illegal argument")),
                Flux.empty(),
                Flux.range(2,10),
                Flux.range(10, 100)
        ).subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        // switchOnNext on flux

        Flux
                .switchOnNext(
                        Flux.just(

                                        Flux.just("This", "is", "String", "flux"),
                                        Flux.range(1, 10)

                        )
                )
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        Stream.of("8","1","9","2","3","10","4","5")
                .sorted(Comparator.naturalOrder())
                .forEach(x -> System.out.print(x + " "));


    }
}
