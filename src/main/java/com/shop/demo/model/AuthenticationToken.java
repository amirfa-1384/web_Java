package com.shop.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;



@Entity
@Table(name ="token")
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "created_date")
    private Date creatDate;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name="user_id")
    private User user;

    public String getToken(){
        return token;
    }

    public AuthenticationToken(User user){
        this.user=user;
        this.creatDate=new Date();
        this.token= UUID.randomUUID().toString();
    }
    public AuthenticationToken() {
    }
}
