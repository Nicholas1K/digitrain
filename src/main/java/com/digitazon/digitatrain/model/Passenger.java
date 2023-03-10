package com.digitazon.digitatrain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer points; //punti accumulati

    @Column
    private String codeCartaFreccia;


    public Passenger() {
    }

    public Passenger(String name, Integer points, String codeCartaFreccia) {
        this.name = name;
        this.points = points;
        this.codeCartaFreccia = codeCartaFreccia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Passeggero [id=" + id + ", name=" + name + ", points=" + points + "]";
    }

}
