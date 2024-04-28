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
@DiscriminatorValue("Children")
public class ChildrenPrice extends Price{
    private final static double charge = 1.5;

    public ChildrenPrice() {
        super();
    }

    @Override
    public double getCharge(int daysRented) {
        double finalCharge = charge;
        if (daysRented > 3)
            finalCharge += (daysRented - 3) * 1.5;
        return finalCharge;
    }
}
