package com.durumluemrullah.rentacar.controllers;

import com.durumluemrullah.rentacar.dataAccess.CarDao;
import com.durumluemrullah.rentacar.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cars")
public class CarsController {

    @Autowired
    private CarDao carDao;

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody Car car){
        carDao.create(car);
        return new ResponseEntity<>("Olusturuldu", HttpStatus.CREATED);
    }
}
