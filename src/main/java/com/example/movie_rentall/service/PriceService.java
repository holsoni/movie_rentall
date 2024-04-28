package com.example.movie_rentall.service;

import com.example.movie_rentall.model.price.Price;
import com.example.movie_rentall.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;

    public void create(Price price) {
        priceRepository.save(price);
    }
}
