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

import com.digitazon.digitatrain.model.Reservation;
import com.digitazon.digitatrain.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservation() {

        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {

        return new ResponseEntity<>(reservationService.findReservationById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable Long id) {

        reservationService.deleteReservationById(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation newReservation) {

        return new ResponseEntity<>(reservationService.saveReservation(newReservation), HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long id, @RequestBody Reservation newReservation) {

        return new ResponseEntity<>(reservationService.updateReservation(newReservation), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservationByID(@PathVariable long id, @RequestBody Reservation newReservation) {

        return new ResponseEntity<>(reservationService.updatReservationById(newReservation, id), HttpStatus.OK);
    }
}
