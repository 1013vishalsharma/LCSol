package com.example.Reactordemo.FluxSample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.*;

public class CreatingASequence {

    public static void main(String[] args) throws InterruptedException {

        /*
         Create a new Mono that emits the specified item if Optional.isPresent() otherwise only emits onComplete.
        */
        Mono.justOrEmpty(Optional.empty()) // this returns empty mon, that just return onComplete signal
                .log()
                .subscribe(System.out::println);

        /*13:44:45.013 [main] DEBUG reactor.util.Loggers - Using Slf4j logging framework
        13:44:45.033 [main] INFO reactor.Mono.Empty.1 - onSubscribe([Fuseable] Operators.EmptySubscription)
        13:44:45.036 [main] INFO reactor.Mono.Empty.1 - request(unbounded)
        13:44:45.037 [main] INFO reactor.Mono.Empty.1 - onComplete()*/

        System.out.println("----------------------------------------");


        /*
        Create a Mono, producing its value using the provided Supplier. If the Supplier resolves to null, the resulting Mono completes empty.
         */
        Mono.fromSupplier(() -> 101)
                .log()
                .subscribe(System.out::println);
        /*
        13:52:00.275 [main] INFO reactor.Mono.Supplier.2 - | onSubscribe([Fuseable] MonoSupplier.MonoSupplierSubscription)
        13:52:00.275 [main] INFO reactor.Mono.Supplier.2 - | request(unbounded)
        13:52:00.275 [main] INFO reactor.Mono.Supplier.2 - | onNext(101)
        101
        13:52:00.276 [main] INFO reactor.Mono.Supplier.2 - | onComplete()
         */
        System.out.println("-----------------------------------------------");
        var rand = new Random();
        Flux<Integer> integerMono = Flux.just(5 * rand.nextInt(), 5 * rand.nextInt(), 5 * rand.nextInt());
        integerMono.subscribe(x -> System.out.print(x + " "));

        //Thread.sleep(5000);
        System.out.println();
        integerMono.subscribe(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("-------------------------------------");

        Flux<Integer> integerDeferMono = Flux.defer(() -> Flux.just(5 * rand.nextInt(), 5 * rand.nextInt(), 5 * rand.nextInt()));
        integerDeferMono.subscribe(x -> System.out.print(x + " "));
        integerDeferMono.

        //Thread.sleep(5000);

        System.out.println();
        integerDeferMono.subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        Flux.fromArray(new Integer[]{1,2,3,4,5})
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        Set<Integer> set = new HashSet<>();
        set.add(-1); set.add(-2); set.add(-3); set.add(-4); set.add(-5);
        Flux.fromIterable(set)
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        Flux.range(1,5)
                .subscribe(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("---------------------------------------------");

        Flux.empty()
                .log()
                .subscribe(x -> System.out.print(x + " "));
        System.out.println("---------------------------------------------");
        System.out.println();

        Flux.error(() -> new IOException("here comes io error"))
                .log()
                .subscribe(x -> System.out.print(x + " "));
        System.out.println("---------------------------------------------");
        System.out.println();
    }
}
