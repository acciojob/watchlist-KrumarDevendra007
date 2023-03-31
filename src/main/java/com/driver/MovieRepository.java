package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, List<String>>  movieDirectorDb = new HashMap<>();

    public void addMovie(Movie movie){

        String key = movie.getName();
        movieDb.put(key, movie);
    }

    public void addDirector(Director director){

        String key = director.getDirectorName();
        directorDb.put(key, director);
    }

    public void addMovieDirectorPair(String director, String movie){

        List<String> list =  movieDirectorDb.get(director);

        if(list == null){
            list = new ArrayList<>();
        }

        list.add(movie);

        movieDirectorDb.put(movie, list);
    }
    public Movie getMovieByName(String movieName){

        return movieDb.get(movieName);
    }

    public Director getDirectorByName(String directorName){

        return directorDb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){

         List<String> movieList = movieDirectorDb.get(directorName);

         return movieList;
    }

    public void deleteDirectorByName(String directorName){

        for(String str : movieDirectorDb.get(directorName)){
            movieDb.remove(directorName);
        }

        directorDb.remove(directorName);
        movieDb.remove(directorName);
    }

    public void deleteAllDirectors(){

        for(String director : directorDb.keySet()){

            for(String str : movieDirectorDb.get(director)){

                movieDb.remove(str);
            }

            movieDirectorDb.remove(director);
            directorDb.remove(director);
        }
    }
}
