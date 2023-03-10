package com.digitazon.digitatrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.digitatrain.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    
}
