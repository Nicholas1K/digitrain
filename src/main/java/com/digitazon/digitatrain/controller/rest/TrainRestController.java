package com.digitazon.digitatrain.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.digitatrain.model.Train;
import com.digitazon.digitatrain.service.TrainService;

@RestController
@RequestMapping("/api/trains")
@CrossOrigin
public class TrainRestController {
    
    @Autowired
    TrainService trainService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Train>> getAllTrains(){
        return new ResponseEntity<>(trainService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable long id){
        return new ResponseEntity<>(trainService.getTrainById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Train> createTrain(@RequestBody Train train){
        return new ResponseEntity<>(trainService.createTrain(train), HttpStatus.CREATED);
    }

}
