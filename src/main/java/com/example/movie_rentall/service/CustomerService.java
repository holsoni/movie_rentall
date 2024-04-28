package com.example.movie_rentall.service;

import com.example.movie_rentall.model.Customer;
import com.example.movie_rentall.model.Rental;
import com.example.movie_rentall.repository.CustomerRepository;
import com.example.movie_rentall.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private static final String RENTAL_HEADING = "Rental Record for %s \n";
    private static final String AMOUNT_OWED_STRING = "Amount owed is %f\n";
    private static final String AMOUNT_FREQUENT_POINTS_STRING = "You earned %d frequent renter points";
    private static final String TABULATION = "\t";
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer getById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public String getStatement(String id) {
        Customer customer = getById(id);
        String statement = String.format(RENTAL_HEADING, customer.getName());
        List<Rental> allByCustomer = rentalRepository.getAllByCustomer(customer);
        statement = getString(allByCustomer, statement);
        statement += String.format(AMOUNT_OWED_STRING, getTotalCharge(allByCustomer));
        statement += String.format(AMOUNT_FREQUENT_POINTS_STRING, getTotalBonusPoints(allByCustomer));
        return statement;
    }

    private String getString(List<Rental> rentals, String result) {
        for (Rental rental : rentals) {
            result += TABULATION + rental.getMovie().getName()+ TABULATION + rental.getCharge() + TABULATION;
        }
        return result;
    }

    private double getTotalCharge(List<Rental> rentals) {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalBonusPoints(List<Rental> rentals) {
        return rentals.stream().mapToInt(Rental::getBonusPoint).sum();
    }

}
