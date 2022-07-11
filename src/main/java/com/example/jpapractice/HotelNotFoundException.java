package com.example.jpapractice;

import lombok.AllArgsConstructor;


public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
