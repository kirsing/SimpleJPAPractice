package com.example.jpapractice.controller;


import com.example.jpapractice.HotelNotFoundException;
import com.example.jpapractice.model.Hotel;
import com.example.jpapractice.repository.HotelRepository;
import com.example.jpapractice.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {
    HotelService hotelService;
    HotelRepository hotelRepository;

    @GetMapping
    public Iterable<Hotel> getAll() {
        return hotelRepository.findAll();
    }
    @GetMapping("/{id}")
    public Hotel findHotelById(@PathVariable int id) {
        return hotelRepository
                .findById(id).orElseThrow(() -> new HotelNotFoundException("House with current id not found"));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        hotelService.deleteById(id);
    }
    @PostMapping
    public Hotel postHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    @GetMapping("/findAllsql")
    public List<Hotel> findAllSql() {
        return hotelService.findAllSQL();
    }
    @GetMapping("/findAllJpql")
    public List<Hotel> findAllJpql() {
        return hotelService.findAllJPQL();
    }
    @GetMapping("/criteria/names")
    public List<String> getCriteriaHotelsNames() {
        return hotelService.getCriteriaHotelsNames();
    }

    @GetMapping("/criteria/sumprices")
    public Integer getCriteriaHotelsSumPrices() {
        return hotelService.getCriteriaHotelSumPrices();
    }
}
