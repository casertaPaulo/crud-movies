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

    @Autowired
    private OmdbService apiService;

    public List<MovieDTO> listAllMovies() {
        List<MovieEntity> movies = movieRepository.findAll();
        return movies.stream().map(MovieDTO::new).toList();
    }

    public MovieDTO addMovie(String title) {
        MovieDTO movieDTO = apiService.getMovie(title);
        movieRepository.save(new MovieEntity(movieDTO));
        return movieDTO;
    }

    public MovieDTO deleteMovie(Long id) {
        MovieEntity movieEntity = movieRepository.getReferenceById(id);
        movieRepository.delete(movieEntity);
        return new MovieDTO(movieEntity);
    }

}
