package com.crud.movies.controller;

import com.crud.movies.dto.MovieDTO;
import com.crud.movies.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @GetMapping("/{title}")
    public ResponseEntity<List<MovieDTO>> search(@PathVariable("title") String title) {
        return ResponseEntity.ok(omdbService.searchMovies(title));
    }
}
