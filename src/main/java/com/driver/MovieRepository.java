package com.driver;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    private HashMap<Director,List<Movie>> hm = new HashMap<>();
    private HashMap<String,Movie> movieDb = new HashMap<>();
    private HashMap<String,Director> directorDb = new HashMap<>();



    public String addMovie(Movie movie){
        String key = movie.getName();
        movieDb.put(key,movie);
        return "added movie";
    } // 1
    public String addDirector(Director director){
        String key = director.getName();
        directorDb.put(key,director);
        return "added dir";
    } // 2

    public String addPair(Movie movie,Director director){
        if(hm.containsKey(director)) {
            List<Movie> movies = hm.get(director);
            movies.add(movie);
            hm.put(director,movies);
        }
        else {
            List<Movie> movieList= new ArrayList<>();
            movieList.add(movie);
            hm.put(director,movieList);
        }
        return "Mapped Successfully";
    } // 3

    public Director getDirectorByName(String name){
        if(directorDb.containsKey(name)){
            return directorDb.get(name);
        }
        return null;
    } // 4
    public Movie getMovieByName(String name){
        if(movieDb.containsKey(name)){
            return movieDb.get(name);
        }
        return null;
    } // 5

    public List<String> getListByDir(Director director){
        List<Movie> movieList = hm.get(director);
        List<String> list  = new ArrayList<>();
        for(Movie movie: movieList ){
            list.add(movie.getName());
        }
        return list;
    } // 6

    public List<Movie> getListMovieList(){
        return new ArrayList<>(movieDb.values());
    } // 7

    public String deleteDirector(Director director){
        List<Movie> movies = hm.get(director);
        for(Movie m : movies){
            movieDb.remove(m.getName());
        }
        hm.remove(director);
        directorDb.remove(director.getName());
        return "Directed deleted";
    } // 8
    public String deleteAll(){
        for(Director d : hm.keySet()) {
            deleteDirector(d);
        }
        hm.clear();
        return "All Director deleted";
    } // 9
}