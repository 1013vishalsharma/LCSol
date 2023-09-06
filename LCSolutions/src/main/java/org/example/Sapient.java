package org.example;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Sapient {

    public static void main(String[] args) {

        IntPredicate predicate =  (x) -> String.valueOf(x).charAt(0) == '1';

        IntStream
                .of(1,2,3,11,56,121,789,9,1221,100000)
                .filter(predicate)
                .forEach(System.out::println);

        int i = 6712345;
        int firstDigit = i;

        while(firstDigit >= 10){
            firstDigit = firstDigit/10;
        }
        System.out.println(firstDigit);
    }

}
