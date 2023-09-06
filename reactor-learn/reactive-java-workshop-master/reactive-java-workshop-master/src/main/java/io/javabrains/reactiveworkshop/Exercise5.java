package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        /*ReactiveSources
                .intNumbersFlux()
                .log()
                .subscribe(x -> System.out.print(x + " "),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("done task"));*/

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources
                .intNumbersFlux()
                .log()
                //.flatMap(x -> Mono.just(x), 7)
                .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("subscription happened");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value + " received");
        request(3);
    }
}