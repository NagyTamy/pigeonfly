package com.pigeon.fly.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotNull
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotNull
    @Column(name = "e_mail", unique = true)
    private String eMail;

    @ManyToMany(mappedBy = "customers")
    List<Order> customers;

    public User(String userName, String eMail){
        this.userName = userName;
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
