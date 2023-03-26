package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = movieService.addMovie(movie);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    } // 1
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    } // 2
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("dirName")
    String dirName){
        String ans = movieService.addPair(movieName,dirName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    } // 3
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie m = movieService.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    } // 4
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director d = movieService.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    } // 5
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String name){
        List<String> m = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    } // 6
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){

        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
    } // 7
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(String name){
        String ans = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    } // 8
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String and  = movieService.deleteAll();
        return new ResponseEntity<>(and,HttpStatus.OK);
    } // 9
}