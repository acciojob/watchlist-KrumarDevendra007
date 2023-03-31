package com.driver;

public class Movie {

    private String name;
    private  int durationInMinutes;
    private double imdbRating;

    public Movie(){
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Movie(String name, double imdbRating, int durationInMinutes) {
        this.name = name;
        this.imdbRating = imdbRating;
        this.durationInMinutes = durationInMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
