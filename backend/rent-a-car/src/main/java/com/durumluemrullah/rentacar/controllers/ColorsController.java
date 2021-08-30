package com.durumluemrullah.rentacar.controllers;

import com.durumluemrullah.rentacar.dataAccess.ColorDao;
import com.durumluemrullah.rentacar.entities.concrete.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path = "/colors")
public class ColorsController {

    @Autowired
    private ColorDao colorDao;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Color>> getAll(){
        return new ResponseEntity<>(colorDao.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody Color color){
        colorDao.create(color);
        return new ResponseEntity<>("Olusturuldu",HttpStatus.CREATED);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody Color color){
        colorDao.update(color);
        return new ResponseEntity<>("Güncellendi",HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id){
        colorDao.delete(id);
        return new ResponseEntity<>("Silindi",HttpStatus.OK);
    }

}
