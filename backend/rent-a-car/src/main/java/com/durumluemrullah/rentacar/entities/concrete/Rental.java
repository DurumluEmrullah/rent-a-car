package com.durumluemrullah.rentacar.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    private int id;
    private int customerId;
    private Date rentDate;
    private Date returnDate;

}
