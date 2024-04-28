package com.example.movie_rentall.model;

/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
        id = UUID.randomUUID().toString();
    }
}
