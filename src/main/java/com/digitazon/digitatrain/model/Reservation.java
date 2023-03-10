package com.digitazon.digitatrain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private Integer carriageNumber;

  @Column
  private String locationCode; // codice postazione

  @Column
  private String typeOfTrip;

  @Column
  private String totalAmount;

  @Column
  private String payment;

  @ManyToOne
  private Passenger passenger;

  @ManyToOne
  private Travel travel;

  public Reservation() {
  }

  public Reservation(
      Integer carriageNumber,
      String locationCode,
      String typeOfTrip,
      String totalAmount,
      String payment,
      Passenger passenger,
      Travel travel) {
    this.carriageNumber = carriageNumber;
    this.locationCode = locationCode;
    this.typeOfTrip = typeOfTrip;
    this.totalAmount = totalAmount;
    this.payment = payment;
    this.passenger = passenger;
    this.travel = travel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getCarriageNumber() {
    return carriageNumber;
  }

  public void setCarriageNumber(Integer carriageNumber) {
    this.carriageNumber = carriageNumber;
  }

  public String getBookingCode() {
    return locationCode;
  }

  public void setBookingCode(String locationCode) {
    this.locationCode = locationCode;
  }

  public String getTypeOfTrip() {
    return typeOfTrip;
  }

  public void setTypeOfTrip(String typeOfTrip) {
    this.typeOfTrip = typeOfTrip;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public Travel getTravels() {
    return travel;
  }

  public void setTravels(Travel travel) {
    this.travel = travel;
  }

  @Override
  public String toString() {
    return ("Reservation [id=" +
        id +
        ", carriageNumber=" +
        carriageNumber +
        ", locationCode=" +
        locationCode +
        ", typeOfTrip=" +
        typeOfTrip +
        ", totalAmount=" +
        totalAmount +
        ", payment=" +
        payment +
        ", passenger=" +
        passenger +
        ", travel=" +
        travel +
        "]");
  }
}
