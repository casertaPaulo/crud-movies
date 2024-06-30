package com.crud.movies.dto;

import com.crud.movies.entity.MovieEntity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    @JsonAlias("Title")
    private String title;
    @JsonAlias("Year")
    private String year;
    @JsonAlias("Poster")
    private String poster;

    public MovieDTO(MovieEntity movieEntity) {
        BeanUtils.copyProperties(movieEntity, this);
    }

    @Override
    public String toString() {
        return "Title: " + title + "| Year: " + year + "| Poster: " + poster;
    }
}
