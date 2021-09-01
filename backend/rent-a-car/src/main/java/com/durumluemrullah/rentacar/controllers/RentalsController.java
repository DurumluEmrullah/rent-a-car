package com.durumluemrullah.rentacar.controllers;

import com.durumluemrullah.rentacar.dataAccess.RentalDao;
import com.durumluemrullah.rentacar.entities.concrete.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/rentals")
public class RentalsController {

    @Autowired
    private RentalDao rentalDao ;


    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Rental>> getAll(){
        return new ResponseEntity<List<Rental>>(rentalDao.getAll(), HttpStatus.OK);
    }
    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody Rental rental){
        rentalDao.create(rental);
        return new ResponseEntity<>("Olusuturuldu",HttpStatus.CREATED);
    }
    @PostMapping(path = "/update")
    public ResponseEntity<String> update (Rental rental){
        rentalDao.update(rental);
        return new ResponseEntity<>("Güncellendi",HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id){
        rentalDao.delete(id);
        return new ResponseEntity<>("Silindi",HttpStatus.OK);
    }

}
