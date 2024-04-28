package com.example.movie_rentall.model.price;

/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("NewRelease")
public class NewReleasePrice extends Price {

    public NewReleasePrice() {
        super();
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getBonusPointsPerMovieGenre(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
