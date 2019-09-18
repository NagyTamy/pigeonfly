package com.pigeon.fly.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 74)
    @Column(name = "country")
    private String country;

    @NotNull
    @Size(max = 85)
    @Column(name = "city")
    private String city;

    @NotNull
    @Size(max = 300)
    @Column(name = "address")
    private String address;


    @ManyToMany(mappedBy = "pickUpAddress")
    List<Order> pickUpAddress;

    @ManyToMany(mappedBy = "deliveryAddress")
    List<Order> deliveryAddress;


    public Address(String country, String city, String address){
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

  public Integer getId() {
    return id;
  }
}
