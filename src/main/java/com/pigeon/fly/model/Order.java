package com.pigeon.fly.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pickup_id")
    private int pickUpAddressId;

    @Column(name = "delivery_id")
    private int deliveryAdressId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "pigeon_id")
    private int pigeonId;

    @ManyToMany
    @JoinTable ( name = "pickup_order",
    joinColumns = @JoinColumn(name = "pickup_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    List<Address> pickUpAddress;

    @ManyToMany
    @JoinTable ( name = "deliver_order",
    joinColumns = @JoinColumn(name = "delivery_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    List<Address> deliveryAddress;

    @ManyToMany
    @JoinTable ( name = "pigeon_order",
    joinColumns = @JoinColumn(name = "pigeon_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    List<Pigeon> pigeons;

    @ManyToMany
    @JoinTable ( name = "customer_order",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    List<User> customers;

    public Order(int pickUpAddressId, int deliveryAdressId, int pigeonId, int userId){
      this.pickUpAddressId = pickUpAddressId;
      this.deliveryAdressId = deliveryAdressId;
      this.pigeonId = pigeonId;
      this.userId = userId;
    }

  public int getDeliveryAdressId() {
    return deliveryAdressId;
  }

  public int getPickUpAddressId() {
    return pickUpAddressId;
  }

  public int getPigeonId() {
    return pigeonId;
  }

  public int getUserId() {
    return userId;
  }

  public Integer getId() {
    return id;
  }
}
