package com.digitazon.digitatrain.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.digitatrain.model.Passenger;
import com.digitazon.digitatrain.service.PassengerService;

@RestController
@RequestMapping("/api/passenger")
@CrossOrigin
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping("/all")
    public ResponseEntity<List<Passenger>> getAllPassenger(){
        
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {

        return new ResponseEntity<>(passengerService.findPassengerById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePassengerById(@PathVariable Long id){

        passengerService.deletePassengerById(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger newPassenger){

        return new ResponseEntity<>(passengerService.savePassenger(newPassenger), HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable long id, @RequestBody Passenger newPassenger) {

        return new ResponseEntity<>(passengerService.updatePassenger(newPassenger), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Passenger> updatePassengerByID(@PathVariable long id, @RequestBody Passenger newPassenger) {

        return new ResponseEntity<>(passengerService.updatPassengerById(newPassenger, id), HttpStatus.OK);
    }
}
