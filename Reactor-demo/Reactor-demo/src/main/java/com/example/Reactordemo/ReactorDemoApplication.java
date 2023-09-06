package com.example.Reactordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ReactorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorDemoApplication.class, args);

		/*HttpClient
				.create()
				.get()
				.uri("https://jsonplaceholder.typicode.com/photos")
				.responseContent()
				.asString()
				.map(e -> {
					System.out.println("chuck  - [[[ "+e+"]]]" );
					return e;
				})
				.subscribe();*/
	}

}
