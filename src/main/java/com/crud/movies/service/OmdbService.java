package com.crud.movies.service;

import com.crud.movies.dto.MovieDTO;
import com.crud.movies.dto.MoviesDTO;
import com.crud.movies.exceptions.MovieNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OmdbService {
    private final String URL_SEARCH = "https://omdbapi.com/?apikey=269dedd8&";

    RestTemplate restTemplate = new RestTemplate();

    public List<MovieDTO> searchMovie(String title) throws Exception {
        MoviesDTO moviesDTO = restTemplate.getForObject(
                URL_SEARCH + "s=" + title.replace(" ", "+"), MoviesDTO.class);

        assert moviesDTO != null;
        if (moviesDTO.getMovieDTOS() == null) {
            throw new MovieNotFoundException();
        }

        return moviesDTO.getMovieDTOS();
    }

    public MovieDTO getMovie(String title) {
        return restTemplate.getForObject(
                URL_SEARCH + "t=" + title.replace(" ", "+"), MovieDTO.class);
    }
}
