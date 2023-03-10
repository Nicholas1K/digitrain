package com.digitazon.digitatrain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.digitatrain.model.Reservation;
import com.digitazon.digitatrain.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepositiry;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TravelService travelService;

    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getPassenger() != null) {
            passengerService.savePassenger(reservation.getPassenger());
        }

        if (reservation.getTravels() != null) {
            travelService.createTravel(reservation.getTravels());
        }

        return reservationRepositiry.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepositiry.findAll();
    }

    public Reservation findReservationById(Long id) {
        Optional<Reservation> tempReservation = reservationRepositiry.findById(id);

        if (tempReservation.isPresent()) {
            return tempReservation.get();
        } else {
            return null;
        }
    }

    public void deleteReservationById(Long id) {
        reservationRepositiry.deleteById(id);
    }

    public Reservation updateReservation(Reservation newReservation) {

        Reservation oldReservation = findReservationById(newReservation.getId());

        if (oldReservation != null) {
            oldReservation.setBookingCode(newReservation.getBookingCode());
            oldReservation.setCarriageNumber(newReservation.getCarriageNumber());
            oldReservation.setPayment(newReservation.getPayment());
            oldReservation.setTotalAmount(newReservation.getTotalAmount());
            oldReservation.setTypeOfTrip(newReservation.getTypeOfTrip());

            return reservationRepositiry.save(oldReservation);
        }
        return null;
    }

    public Reservation updatReservationById(Reservation newReservation, Long id) {

        Optional<Reservation> tempReservation = reservationRepositiry.findById(newReservation.getId());

        if (tempReservation.isPresent()) {
            Reservation oldReservation = tempReservation.get();

            oldReservation.setBookingCode(newReservation.getBookingCode());
            oldReservation.setCarriageNumber(newReservation.getCarriageNumber());
            oldReservation.setPayment(newReservation.getPayment());
            oldReservation.setTotalAmount(newReservation.getTotalAmount());
            oldReservation.setTypeOfTrip(newReservation.getTypeOfTrip());

            return reservationRepositiry.save(oldReservation);
        }
        return null;
    }
}
