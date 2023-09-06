package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {
        Stream.of("lorem", "ipsum", "dolor", "sit", "amet")
                .map(String::toCharArray)
                //.
                .forEach(System.out::println);
    }
}
