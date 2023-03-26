package com.driver;

import com.driver.Director;
import com.driver.Movie;
import com.driver.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    //check if movie already exist in List other wise add it in to List
    @Autowired
    MovieRepository movieRepository;
    public  String addMovie(Movie movie) {

        return movieRepository.addMovie(movie);
    } // 1
    public  String addDirector(Director director) {
        return  movieRepository.addDirector(director);
    } // 2
    public String addPair(String movieName,String dirName){

        return movieRepository.addPair(movieRepository.getMovieByName(movieName),movieRepository.getDirectorByName(dirName));
    } // 3
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    } // 4
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    } // 5
    public List<String> getMoviesByDirectorName(String name){
        Director director = movieRepository.getDirectorByName(name);
        return movieRepository.getListByDir(director);
    } // 6
    public List<Movie> findAllMovies(){
        return movieRepository.getListMovieList();
    } // 7
    public String deleteDirectorByName(String name){
        Director d = movieRepository.getDirectorByName(name);
        return movieRepository.deleteDirector(d);
    } // 8
    public String deleteAll(){
        return movieRepository.deleteAll();
    } // 9
}