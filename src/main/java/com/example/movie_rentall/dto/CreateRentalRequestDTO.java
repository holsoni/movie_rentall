package com.example.movie_rentall.dto;
/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateRentalRequestDTO {
    String customerId;
    String movieId;
    LocalDate start;
    LocalDate finish;
}
