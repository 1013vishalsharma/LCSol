package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources
                .intNumbersStream()
                .forEach((x) -> System.out.print(x + " "));

        System.out.println();
        // Print numbers from intNumbersStream that are less than 5
        StreamSources
                .intNumbersStream()
                .filter(x -> x < 5)
                .forEach(a -> System.out.print(a + " "));

        System.out.println();
        // Print the second and third numbers in intNumbersStream that's greater than 5
        int count = 0;
        StreamSources
                .intNumbersStream()
                .filter(x -> x > 5)
                .skip(1)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        StreamSources
                .intNumbersStream()
                .filter(x -> x > 5)
                .findFirst()
                .ifPresentOrElse((x) -> System.out.println("value found: " + x),
                        () -> System.out.println("value not found: -1"));

        // Print first names of all users in userStream
        StreamSources
                .userStream()
                .map(x -> x.getFirstName())
                .forEach(x -> System.out.print(x + " "));

        System.out.println();
        // Print first names in userStream for users that have IDs from number stream
        StreamSources
                .intNumbersStream()
                .flatMap(x -> StreamSources.userStream().filter(a -> a.getId() == x))
                .map(aa -> aa.getFirstName())
                .forEach(System.out::println);

    }

}
