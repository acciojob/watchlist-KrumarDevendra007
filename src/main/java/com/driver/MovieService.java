package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirecto(Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String movieName){

        Movie movie = movieRepository.getMovieByName(movieName);

        return movie;
    }

   public Director getDirectorByName(String directorName){

        Director director = movieRepository.getDirectorByName(directorName);

        return director;
   }

   public List<String> findAllMovies(){
        List<String> list = movieRepository.findAllMovies();
        return list;
   }

   public List<String> getMoviesByDirectorName(String directorName){

        List<String> movieList = movieRepository.getMoviesByDirectorName(directorName);

        return movieList;
   }

   public void deleteDirectorByName(String directorName){

        movieRepository.deleteDirectorByName(directorName);
   }

   public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
   }
}
