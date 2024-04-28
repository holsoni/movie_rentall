package com.example.movie_rentall.repository;

import com.example.movie_rentall.model.Customer;
import com.example.movie_rentall.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie, String> {
}
