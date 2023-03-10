package com.digitazon.digitatrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.digitatrain.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    
}
