package com.example.movie_rentall.repository;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import com.example.movie_rentall.model.Customer;
import com.example.movie_rentall.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository  extends JpaRepository<Rental, String> {
    List<Rental> getAllByCustomer(Customer customer);
}
