package com.example.movie_rentall.service;

import com.example.movie_rentall.dto.CreateRentalRequestDTO;
import com.example.movie_rentall.model.Genre;
import com.example.movie_rentall.model.Movie;
import com.example.movie_rentall.model.Rental;
import com.example.movie_rentall.model.price.ChildrenPrice;
import com.example.movie_rentall.model.price.HorrorPrice;
import com.example.movie_rentall.model.price.NewReleasePrice;
import com.example.movie_rentall.model.price.Price;
import com.example.movie_rentall.model.price.RegularPrice;
import com.example.movie_rentall.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final CustomerService customerService;
    private final MovieService movieService;
    private final PriceService priceService;

    public Rental createRental(CreateRentalRequestDTO rentalRequest) {
        Rental rental = new Rental();
        rental.setId(String.valueOf(UUID.randomUUID()));
        rental.setCustomer(customerService.getById(rentalRequest.getCustomerId()));
        rental.setStart(rentalRequest.getStart());
        rental.setFinish(rentalRequest.getFinish());
        Movie movieForRent = movieService.getById(rentalRequest.getMovieId());
        rental.setMovie(movieForRent);

        try {
            Price price = getPriceForRental(movieForRent.getGenre(), rentalRequest.getStart(), rentalRequest.getFinish());
            rental.setPrice(price);
            priceService.create(price);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        rentalRepository.save(rental);
        return rental;
    }

    private Price getPriceForRental(Genre genre, LocalDate start, LocalDate finish) throws ClassNotFoundException {
        return switch (genre) {
            case HORROR -> new HorrorPrice();
            case REGULAR -> new RegularPrice();
            case CHILDREN -> new ChildrenPrice();
            case NEW_RELEASE -> new NewReleasePrice();
        };
    }

}
