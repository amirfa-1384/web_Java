package com.shop.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "idGame")
    private int idGame;

    @Column(name = "password")
    private String password;


    public User(Long id, String firstName, String lastName, String email, String phone, int idGame, String password) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.idGame = idGame;
        this.password = password;
    }

    public User() {

    }


}
