package com.example.Reactordemo.config;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component("foo")
public class SecurityUSage {
    /*public Mono<Boolean> canAccess() {
        System.out.println("inside security usage method");
        return ReactiveSecurityContextHolder.getContext()
                .map(p -> true);
    }*/

    public boolean canAccess() {
        System.out.println("inside security usage method");
        return true;
    }
}
