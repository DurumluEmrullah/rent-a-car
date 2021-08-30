package com.durumluemrullah.rentacar.controllers;

import com.durumluemrullah.rentacar.dataAccess.BrandDao;
import com.durumluemrullah.rentacar.entities.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/brands")
public class BrandsController {

    @Autowired
    private BrandDao brandDao;

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody Brand brand){
        brandDao.create(brand);
        return new ResponseEntity<>("Olusturuldu", HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Brand>> getAll(){
        return new ResponseEntity<>(brandDao.getAll(),HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id){
        brandDao.delete(id);
        return new ResponseEntity<>("Silindi",HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody Brand brand){
        brandDao.update(brand);
        return new ResponseEntity<>("güncellendi",HttpStatus.OK);
    }
}
