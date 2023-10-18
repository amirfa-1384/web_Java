package com.shop.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product")
@Builder
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String productName;

    @Column
    private Long inventory;
    @Column
    private Long price;


    public Products(Long id, String productName, Long inventory, Long price) {
        Id = id;
        this.productName = productName;
        this.inventory = inventory;
        this.price = price;
    }

    public Products() {

    }
}
