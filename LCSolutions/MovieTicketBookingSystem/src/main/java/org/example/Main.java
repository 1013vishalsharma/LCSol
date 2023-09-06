package org.example;

import org.example.entity.Genre;
import org.example.entity.Movie;
import org.example.service.BookingService;
import org.example.service.MovieService;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MovieService movieService = new MovieService();
        movieService.createMovies("Goofy", "english", Genre.COMEDY);
        movieService.createMovies("Conjuring", "english", Genre.HORROR);
        movieService.createMovies("Ugly", "english", Genre.THRILLER);

        BookingService bookingService = new BookingService(5,5);
        bookingService.showAllSeats();
        Random rand = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i<100; i++){
            Thread.sleep(rand.nextInt(5));
            executor.submit(() -> bookingService.bookSingleSeat(rand.nextInt(5), rand.nextInt(5)));
        }
        bookingService.showAllSeats();
        executor.shutdownNow();

    }
}