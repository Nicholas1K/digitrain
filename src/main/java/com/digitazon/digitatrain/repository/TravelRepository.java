package com.digitazon.digitatrain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.digitatrain.model.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long>{

    public Travel findTravelByDepartureCity(String departureCity);
    public Travel findTravelByArrivalCity(String arrivalCity);
    public List<Travel> findAllByDepartureTime(LocalDateTime departureTime);
    public List<Travel> findAllByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);
    public List<Travel> findAllByDepartureCityAndArrivalCityAndDepartureTimeAfter(String departureCity, String arrivalCity, LocalDateTime startingTime);
    
}
