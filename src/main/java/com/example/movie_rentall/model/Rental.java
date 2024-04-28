package com.example.movie_rentall.model;

/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import com.example.movie_rentall.model.price.Price;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Rental {
    @Id
    private String id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Movie movie;
    @ManyToOne
    private Price price;
    private LocalDate start;
    private LocalDate finish;

    public Rental() {
        id = UUID.randomUUID().toString();
    }

    public int getDaysRented() {
        if (finish.getMonthValue() == start.getMonthValue()) {
            return finish.getDayOfMonth() - start.getDayOfMonth() + 1;
        } else {
            int daysInStartMonth = start.lengthOfMonth() - start.getDayOfMonth() + 1;
            int daysInFinishMonth = finish.getDayOfMonth();

            int daysInMonthsBetween = 0;
            for (int month = start.getMonthValue() + 1; month < finish.getMonthValue(); month++) {
                YearMonth yearMonth = YearMonth.of(start.getYear(), month);
                daysInMonthsBetween += yearMonth.lengthOfMonth();
            }

            return daysInStartMonth + daysInFinishMonth + daysInMonthsBetween;
        }
    }


    public double getCharge() {
        return getPrice().getCharge(getDaysRented());
    }

    public int getBonusPoint() {
        return getPrice().getBonusPointsPerMovieGenre(getDaysRented());
    }
}
