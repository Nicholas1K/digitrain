package com.digitazon.digitatrain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.digitatrain.model.Passenger;
import com.digitazon.digitatrain.repository.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger savePassenger(Passenger passenger){
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassengerById(Long id){
        Optional<Passenger> tempPassenger = passengerRepository.findById(id);

        if(tempPassenger.isPresent()){
            return tempPassenger.get();
        }else{
            return null;
        }
    }

    public void deletePassengerById(Long id) {
        passengerRepository.deleteById(id);
    }

    public Passenger updatePassenger(Passenger newPassenger){

        Passenger oldPassenger = findPassengerById(newPassenger.getId());

        if(oldPassenger != null){
            oldPassenger.setName(newPassenger.getName());
            oldPassenger.setPoints(newPassenger.getPoints());

            return passengerRepository.save(oldPassenger);
        }
        return null;
    }

    public Passenger updatPassengerById(Passenger newPassenger, Long id){

        Optional<Passenger> tempPassenger = passengerRepository.findById(newPassenger.getId());

        if(tempPassenger.isPresent()){
            Passenger oldPassenger = tempPassenger.get();

            oldPassenger.setName(newPassenger.getName());
            oldPassenger.setPoints(newPassenger.getPoints());

            return passengerRepository.save(oldPassenger);
        }
        return null;
    }
    
}
