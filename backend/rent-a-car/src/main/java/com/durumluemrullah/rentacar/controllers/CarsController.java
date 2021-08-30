package com.durumluemrullah.rentacar.controllers;

import com.durumluemrullah.rentacar.dataAccess.CarDao;
import com.durumluemrullah.rentacar.entities.concrete.Car;
import com.durumluemrullah.rentacar.entities.dtos.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Car>> getAll(){
        return new ResponseEntity<>(carDao.getAll(),HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id){
        carDao.delete(id);
        return new ResponseEntity<>("Silindi",HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody Car car){
        carDao.update(car);
        return new ResponseEntity<>("Güncellendi", HttpStatus.OK);
    }

    @GetMapping(path = "/getCarDetails")
    public ResponseEntity<List<CarDto>> getCarDetails(){
        return new ResponseEntity<>(carDao.getAllCarDetails(),HttpStatus.OK);
    }

    @GetMapping(path = "/filterByColorIdAndBrandId/{colorId}/{brandId}")
    public ResponseEntity<List<CarDto>> filterByColorIdAndBrandId(@PathVariable(name = "colorId") int colorId,
                                                                  @PathVariable(name = "brandId") int brandId){


        return new ResponseEntity<>(carDao.filterByColorIdAndBrandId(brandId,colorId),HttpStatus.OK);
    }
}
