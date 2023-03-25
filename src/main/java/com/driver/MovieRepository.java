package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository() {
        movieMap = new HashMap<>();
        directorMap = new HashMap<>();
        directorMovieMap = new HashMap<>();
    }

    // method to add movie to db
    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    } // 1

    // method to add director db
    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    } // 2

    // method to add movie director pair db
    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey((director))){
            List<String> currMovie = new ArrayList<>();
            if (directorMovieMap.containsKey(director)) currMovie = directorMovieMap.get(director);
            currMovie.add(movie);
            directorMovieMap.put(director, currMovie);
        } // 3
    }

    // method find movie
    public Movie findMovie(String movie){
        return movieMap.get(movie);
    } // 4


    // method to find director

    public  Director findDirector(String director){
        return directorMap.get(director);
    } // 5

    // method to find movie list according to director
    public List<String> findMovieFromDirector(String director){
        List<String> movieList=new ArrayList<>();
        if(directorMovieMap.containsKey(director)) movieList=directorMovieMap.get(director);
        return movieList;
    } // 6

    // method to find all the movie name

    public List<String> findAllMovie(){
        return new ArrayList<>(movieMap.keySet());
    } //7

    // method to remove movie and director
    public  void deleteDirectorByName(String director){
        if(directorMap.containsKey(director)&&directorMovieMap.containsKey(director)){
            for(String movie: directorMovieMap.get(director)) movieMap.remove(movie);

            directorMovieMap.remove(director);
        } // 8
    }

    // method to delete all the director and their movies..
    public  void deleteAllDirectors(){ //9;
        for(String director: directorMap.keySet()){
            if(directorMovieMap.containsKey(director)){
                for(String movie: directorMovieMap.get(director)){
                    movieMap.remove(movie);
                }
                directorMovieMap.remove(director);
            }else{
                directorMap.remove(director);
            }
        }
    }
}
