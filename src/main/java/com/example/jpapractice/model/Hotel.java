package com.example.jpapractice.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hotels_table")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private int id;

    @Column(name = "hotel_name")
    private String name;

    @Column(name = "rent_price")
    private int price;
}
