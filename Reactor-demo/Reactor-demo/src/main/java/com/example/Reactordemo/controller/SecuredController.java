package com.example.Reactordemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("secured")
public class SecuredController {

    @GetMapping
    @PreAuthorize("@foo.canAccess()")
    public Mono<String> testSecurity(){
        return Mono.just("This is secured response")
                .doOnSuccess(System.out::println);
    }
}
