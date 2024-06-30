package com.crud.movies.service;

import com.crud.movies.dto.MovieDTO;
import com.crud.movies.dto.MoviesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OmdbService {
    private final String URL_SEARCH = "https://omdbapi.com/?apikey=269dedd8&s=";

    RestTemplate restTemplate = new RestTemplate();

    public List<MovieDTO> searchMovies(String title) {
        MoviesDTO moviesDTO = restTemplate.getForObject(URL_SEARCH + title.replace(" ", "+"), MoviesDTO.class);
        assert moviesDTO != null;
        return moviesDTO.getMovieDTOS();
    }
}
