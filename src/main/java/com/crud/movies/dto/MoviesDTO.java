package com.crud.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MoviesDTO {
    @JsonProperty("Search")
    private List<MovieDTO> movieDTOS;
}
