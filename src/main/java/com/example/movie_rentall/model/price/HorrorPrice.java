package com.example.movie_rentall.model.price;

/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Horror")
public class HorrorPrice extends Price{
    private final static double charge = 3;

    public HorrorPrice() {
        super();
    }

    @Override
    public double getCharge(int daysRented) {
        double finalCharge = charge;
        if (daysRented > 4)
            finalCharge += (daysRented - 4) * 2;
        return finalCharge;
    }

    @Override
    public int getBonusPointsPerMovieGenre(int daysRented) {
        if (daysRented > 3) {
            return 2;
        }
        return 1;
    }
}
