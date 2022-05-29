package com.demo.DbHw1.Controller;

import com.demo.DbHw1.Model.Movie;
import com.demo.DbHw1.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovie() {
        return ResponseEntity.status(200).body(movieService.getMovie());
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("New Movie added");
    }

    @PutMapping("/")
    public ResponseEntity putMovie(@RequestBody Movie user, @PathVariable Integer id) {
        movieService.putMovie(user, id);
        return ResponseEntity.status(200).body("New Movie updated");
    }

    @DeleteMapping("/")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("New Movie deleted");
    }
}
