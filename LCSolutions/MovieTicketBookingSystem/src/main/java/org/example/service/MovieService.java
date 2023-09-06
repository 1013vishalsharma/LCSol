package org.example.service;

import org.example.entity.Genre;
import org.example.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    List<Movie> movies;
    NotificationService notificationService;
    public MovieService(){
        movies = new ArrayList<>();
        notificationService = new NotificationService();
    }
    public void createMovies(String title, String language, Genre genre){
        movies.add(new Movie(title, language, genre));
        notificationService.notifyUser();
    }

    public List<Movie> findAllMovies(){
        System.out.println(movies);
        return movies;
    }

    /*public List<Movie> findMovieBy(String filter, String value){
        for (Movie movie: movies){

        }
    }*/
}
