package com.durumluemrullah.rentacar.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private String colorName;
    private String brandName;
    private double dailyPrice;
    private int modelYear;
    private String description;
}
