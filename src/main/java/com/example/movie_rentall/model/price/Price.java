package com.example.movie_rentall.model.price;

/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@AllArgsConstructor
public abstract class Price {
    @Id
    private String id;

    public Price() {
        id = UUID.randomUUID().toString();
    }

    public abstract double getCharge(int daysRented);
    public int getBonusPointsPerMovieGenre(int daysRented) {
        return 1;
    }
}
