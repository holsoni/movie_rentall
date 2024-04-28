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
@DiscriminatorValue("Regular")
public class RegularPrice extends Price{
    private final static double charge = 2;

    public RegularPrice() {
        super();
    }

    @Override
    public double getCharge(int daysRented) {
        double finalCharge = charge;
        if (daysRented > 2)
            finalCharge += (daysRented - 2) * 1.5;
        return finalCharge;
    }
}
