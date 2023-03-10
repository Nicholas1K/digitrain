package com.digitazon.digitatrain.controller.rest;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.digitatrain.model.Travel;
import com.digitazon.digitatrain.service.TravelService;

@RestController
@RequestMapping("/api/travels")
@CrossOrigin
public class TravelRestController {
    
    @Autowired
    TravelService travelService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Travel>> getAllTravels(){
        return new ResponseEntity<>(travelService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable long id){
        return new ResponseEntity<>(travelService.getTravelById(id), HttpStatus.OK);
    }

    @GetMapping("/depcity/{departureCity}")
    public ResponseEntity<Travel> getTravelByDepartureCity(@PathVariable String departureCity){
        return new ResponseEntity<>(travelService.getTravelByDepartureCity(departureCity), HttpStatus.OK);
    }

    @GetMapping("/arrcity/{arrivalCity}")
    public ResponseEntity<Travel> getTravelByArrivalCity(@PathVariable String arrivalCity){
        return new ResponseEntity<>(travelService.getTravelByArrivalCity(arrivalCity), HttpStatus.OK);
    }

    @GetMapping("/bothcities")
    public ResponseEntity<List<Travel>> getTravelByDepartureCityAndByArrivalCity(@RequestParam(name = "departure") String departureCity, @RequestParam(name = "arrival")  String arrivalCity){
        return new ResponseEntity<>(travelService.getTravelByDepartureCityAndArrivalCity(departureCity, arrivalCity), HttpStatus.OK);
    }

    @GetMapping("/bothcitiesandtime")
    public ResponseEntity<List<Travel>> getTravelByDepartureCityAndArrivalCityWithStartingTime(@RequestParam(name = "departure") String departureCity, @RequestParam(name = "arrival") String arrivalCity, @RequestParam(name = "time") LocalDateTime startingTime){
        return new ResponseEntity<>(travelService.getTravelByDepartureCityAndArrivalCityAndDepartureTimeAfter(departureCity, arrivalCity, startingTime), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Travel> createTravel(@RequestBody Travel travel){
        return new ResponseEntity<>(travelService.createTravel(travel), HttpStatus.CREATED);
    }

}
