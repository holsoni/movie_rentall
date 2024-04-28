package com.example.movie_rentall.repository;

import com.example.movie_rentall.model.price.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, String> {
}
