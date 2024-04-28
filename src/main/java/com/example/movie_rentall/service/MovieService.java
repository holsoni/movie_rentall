package com.example.movie_rentall.service;

import com.example.movie_rentall.model.Movie;
import com.example.movie_rentall.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getById(String id) {
        return movieRepository.getReferenceById(id);
    }
}
