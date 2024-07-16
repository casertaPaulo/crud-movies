package com.crud.movies.controller;

import com.crud.movies.dto.MovieDTO;
import com.crud.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin()
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDTO> listAll() {
        return movieService.listAllMovies();
    }

    @PostMapping("/{title}")
    public ResponseEntity<MovieDTO> insert(@PathVariable("title") String title) {
        return new ResponseEntity<>(movieService.addMovie(title) ,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDTO> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(movieService.deleteMovie(id), HttpStatus.OK);
    }
}
