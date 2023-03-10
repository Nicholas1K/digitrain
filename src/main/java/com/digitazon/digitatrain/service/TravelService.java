package com.digitazon.digitatrain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.digitatrain.model.Travel;
import com.digitazon.digitatrain.repository.TravelRepository;

@Service
public class TravelService {

  @Autowired
  TravelRepository travelRepository;

  public Travel createTravel(Travel newTravel) {
    return travelRepository.save(newTravel);
  }

  public List<Travel> getAll() {
    return travelRepository.findAll();
  }

  public Travel getTravelById(long id) {
    return travelRepository.findById(id).get();
  }

  public Travel getTravelByDepartureCity(String departureCity) {
    return travelRepository.findTravelByDepartureCity(departureCity);
  }

  public Travel getTravelByArrivalCity(String arrivalCity) {
    return travelRepository.findTravelByArrivalCity(arrivalCity);
  }

  public List<Travel> getTravelByDepartureCityAndArrivalCity(String departureCity, String arrivalCity) {
    return travelRepository.findAllByDepartureCityAndArrivalCity(departureCity, arrivalCity);
  }

  public List<Travel> getTravelByDepartureTime(LocalDateTime departureTime) {
    return travelRepository.findAllByDepartureTime(departureTime);
  }

  public List<Travel> getTravelByDepartureCityAndArrivalCityAndDepartureTimeAfter(String departureCity, String arrivalCity, LocalDateTime startingTime){
    return travelRepository.findAllByDepartureCityAndArrivalCityAndDepartureTimeAfter(departureCity, arrivalCity, startingTime);
  }

    // public Travel getTravelByDepartureCityAndArrivalCityWithStartingTime(String departureCity, String arrivalCity, LocalDateTime startingTime){
    //   Travel travel = travelRepository.findTravelByDepartureCityAndArrivalCity(departureCity, arrivalCity);

    //   int travelYear = travel.getDepartureTime().getYear();
    //   int travelMonth = travel.getDepartureTime().getMonthValue();
    //   int travelDay = travel.getDepartureTime().getDayOfYear();
    //   int travelHour = travel.getDepartureTime().getHour();
    //   int travelMinute = travel.getDepartureTime().getMinute();
            
    //   int startingYear = startingTime.getYear();
    //   int startingMonth = startingTime.getMonthValue();
    //   int startingDay = startingTime.getDayOfYear();
    //   int startingHour = startingTime.getHour();
    //   int startingMinute = startingTime.getMinute();
      
    //   if (travelYear > startingYear && travelMonth > startingMonth && travelDay > startingDay && travelHour > startingHour && travelMinute > startingMinute ){
    //     return travel;
    //   }
    //    return null;
    // }
}
