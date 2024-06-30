package com.crud.movies.controller;

import com.crud.movies.dto.MovieDTO;
import com.crud.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDTO> listAll() {
        return movieService.listAllMovies();
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @PostMapping("/{title}")
    public ResponseEntity<String> insertFromApi(@PathVariable("title") String title) {
        return movieService.addMovieFromApi(title);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody MovieDTO movieDTO) {
        return movieService.updateMovie(movieDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie Deleted");
    }
}
