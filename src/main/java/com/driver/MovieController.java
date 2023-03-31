package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);

        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirecto(director);

        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-movie-director-pair")
    public  ResponseEntity<String> addMovieDirectorPair(@RequestParam("director")String diroctor, @RequestParam("movie")String movie){
        movieService.addMovieDirectorPair(diroctor, movie);

        return new ResponseEntity<>("New director movie pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("movieName")String movieName){

          Movie movie = movieService.getMovieByName(movieName);

         return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/getDirectorByName")
    public ResponseEntity<Director>  getDirectorByName(@RequestParam("directorName")String directorName){

        Director director = movieService.getDirectorByName(directorName);

        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(String directorName){

        movieService.getMoviesByDirectorName(directorName);

        return new ResponseEntity<>("Director remove successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        movieService.deleteAllDirectors();

        return new ResponseEntity<>("All directors remove successfully", HttpStatus.CREATED);
    }
}
