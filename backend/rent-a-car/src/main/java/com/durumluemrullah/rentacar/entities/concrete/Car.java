package com.durumluemrullah.rentacar.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {

    private int carId;
    private int brandId;
    private int colorId;
    private int modelYear;
    private double dailyPrice;
    private String description;

}
