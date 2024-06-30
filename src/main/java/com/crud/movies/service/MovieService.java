package com.crud.movies.service;

import com.crud.movies.dto.MovieDTO;
import com.crud.movies.entity.MovieEntity;
import com.crud.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@CrossOrigin
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> listAllMovies() {
        List<MovieEntity> movies = movieRepository.findAll();
        return movies.stream().map(MovieDTO::new).toList();
    }

    public ResponseEntity<String> addMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity(movieDTO);
        movieRepository.save(movieEntity);
        return ResponseEntity.ok("Movie created in the database");
    }

    //
    public ResponseEntity<String> addMovieFromApi(String title) {
        try {
        RestTemplate restTemplate = new RestTemplate();
            MovieDTO movieDTO = restTemplate.getForObject("https://omdbapi.com/?apikey=269dedd8&t="+title.replace(" ", "+"), MovieDTO.class);
            MovieEntity movieEntity = new MovieEntity(movieDTO);
            movieRepository.save(movieEntity);
            return ResponseEntity.ok("Request ok, movie created");
        } catch (Exception e) {
            return ResponseEntity.ok("Error \n" + e.getMessage());
        }
    }

    public ResponseEntity<String> updateMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity(movieDTO);
        movieRepository.save(movieEntity);
        return ResponseEntity.ok("Movie updated");
    }

    public ResponseEntity<String> deleteMovie(Long id) {
        MovieEntity movieEntity = movieRepository.getReferenceById(id);
        movieRepository.delete(movieEntity);
        return ResponseEntity.ok("Movie deleted");
    }

}
