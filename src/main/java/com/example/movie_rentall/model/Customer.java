package com.example.movie_rentall.model;

/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;

    public Customer(String name) {
        id = UUID.randomUUID().toString();
    }
}
