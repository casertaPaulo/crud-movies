package com.crud.movies.entity;

import com.crud.movies.dto.MovieDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Table(name = "movies")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String year;
    private String poster;

    public MovieEntity(MovieDTO movieDTO) {
        BeanUtils.copyProperties(movieDTO, this);
    }
}
