package com.digitazon.digitatrain;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digitazon.digitatrain.model.Passenger;
import com.digitazon.digitatrain.model.Reservation;
import com.digitazon.digitatrain.model.Train;
import com.digitazon.digitatrain.model.Travel;
import com.digitazon.digitatrain.service.PassengerService;
import com.digitazon.digitatrain.service.ReservationService;
import com.digitazon.digitatrain.service.TrainService;
import com.digitazon.digitatrain.service.TravelService;

@Component
public class DigitatrainDataLoader implements CommandLineRunner {

    @Autowired
    TrainService trainService;

    @Autowired
    TravelService travelService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    ReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {
        
        for (int i = 0; i<10; i++){
            trainService.createTrain(new Train("A00"+i, "Viaggiatori"));
        }

        for (int i = 0; i<10; i++){
            trainService.createTrain(new Train("A00"+i, "Merci"));
        }

        Travel travel1 = new Travel("Milano", "Roma", LocalDateTime.of(2023, 1, 12, 10, 0, 0), LocalDateTime.of(2023, 1, 12, 16,0,0), trainService.getTrainById(1));
        Travel travel2 = new Travel("Milano", "Torino", LocalDateTime.of(2023, 1, 12, 10, 0, 0), LocalDateTime.of(2023, 1, 12, 14,0,0), trainService.getTrainById(2));
        Travel travel3 = new Travel("Bergamo", "Venezia", LocalDateTime.of(2023, 1, 12, 01, 0, 0), LocalDateTime.of(2023, 1, 12, 03,0,0), trainService.getTrainById(3));
        Travel travel4 = new Travel("Roma", "Milano", LocalDateTime.of(2023, 1, 12, 10, 0, 0), LocalDateTime.of(2023, 1, 12, 16,0,0), trainService.getTrainById(4));
        Travel travel5 = new Travel("Milano", "Roma", LocalDateTime.of(2023, 1, 12, 14, 0, 0), LocalDateTime.of(2023, 1, 12, 20,0,0), trainService.getTrainById(1));
        
        travelService.createTravel(travel1);
        travelService.createTravel(travel2);
        travelService.createTravel(travel3);
        travelService.createTravel(travel4);
        travelService.createTravel(travel5);

        Passenger p1 = new Passenger("Nicholas Tizzani", 150, "ANHAG");
        Passenger p2 = new Passenger("Davide Di Criscito", 200, "ALOKJ");
        Passenger p3 = new Passenger("Matteo Bruno", 200, "AHKSN");
        Passenger p4 = new Passenger("Patrick Annese", 175, "AHJKJ");
        Passenger p5 = new Passenger("Eleonora Pisacane", 150, "AHSSL");

        passengerService.savePassenger(p1);
        passengerService.savePassenger(p2);
        passengerService.savePassenger(p3);
        passengerService.savePassenger(p4);
        passengerService.savePassenger(p5);

        Reservation r1 = new Reservation(4, "D14", "Business", "150.0", "PayPal", p5, travel4);
        Reservation r2 = new Reservation(6, "A08", "Economy", "50.0", "Contanti", p5, travel4);
        Reservation r3 = new Reservation(9, "C20", "Premium", "70.0", "Carta di Credito", p5, travel4);
        Reservation r4 = new Reservation(1, "B01", "Business", "200.0", "PayPal", p5, travel4);

        reservationService.saveReservation(r1);
        reservationService.saveReservation(r2);
        reservationService.saveReservation(r3);
        reservationService.saveReservation(r4);

        System.out.println("Connessione riuscita.");

    }
    
}
