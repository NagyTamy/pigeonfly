package com.pigeon.fly.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "pigeon")
public class Pigeon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "reserved_since")
    private LocalDateTime reservation_time;

    @NotNull
    @Column(name = " carrying_capacity")
    private int carryingCapacity;                           //registered in grams

    @NotNull
    @Column(name = "speed")
    private int speed;                                      //registered in km/hr

    @Column(name = "available")
    private boolean isAvailable = true;

    @Column(name = "picture")
    private String path;

    @ManyToMany(mappedBy = "pigeons")
    List<Order> pigeons;

    public Pigeon(){

    }

    public Pigeon(String name, int carryingCapacity, int speed, String path){
        this.name = name;
        this.carryingCapacity = carryingCapacity;
        this.speed = speed;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setReservation_time(LocalDateTime reservation_time) {
        this.reservation_time = reservation_time;
    }

    public LocalDateTime getReservation_time() {
        return reservation_time;
    }

  public String getPath() {
    return path;
  }

  public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}


//    id                SERIAL PRIMARY KEY,
//    name              text UNIQUE,
//    reserved_since    TIMESTAMP WITH TIME ZONE,
//    carrying_capacity int NOT NULL,
//    speed             int NOT NULL,
//    CONSTRAINT capacity_not_null CHECK (carrying_capacity IS NOT NULL),
//    CONSTRAINT speed_not_null CHECK ( speed IS NOT NULL )
