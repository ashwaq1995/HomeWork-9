package com.demo.DbHw1.Service;

import com.demo.DbHw1.Model.Movie;
import com.demo.DbHw1.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    
    private final MovieRepository movieRepository;


    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public boolean addMovie(Movie movie) {
        movieRepository.save(movie);
        return false;
    }


    public void putMovie(Movie newMovie, Integer id) {
        Movie oldMovie = movieRepository.findById(id).get();
        oldMovie.setName(newMovie.getName());
        oldMovie.setGenre(newMovie.getGenre());
        oldMovie.setRating(newMovie.getRating());
        oldMovie.setDuration(newMovie.getDuration());
        oldMovie.setLaunchDate(newMovie.getLaunchDate());
        movieRepository.save(oldMovie);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
