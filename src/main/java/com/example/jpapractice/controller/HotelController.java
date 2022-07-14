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
//        return hotelService.findAllSQL();
        return hotelService.findAllSQL();
    }
    @GetMapping("/findAllsql/{id}/{price}")
    public List<Hotel> findAllSql2(@PathVariable int id, @PathVariable int price) {
//        return hotelService.findAllSQL();
        return hotelService.findAllSQLParam(id, price);
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
    @GetMapping("/keywords/gtprices/{id}/{price}")
    public List<Hotel> findByIdAndPriceGreaterThan(@PathVariable int id, @PathVariable int price) {
//        return hotelRepository.findByIdOrPriceGreaterThan(id, price);
//        return hotelRepository.findByIdOrPriceGreaterThansql(id, price);
        return hotelRepository.findByIdOrPriceGreaterThanjpql(id, price);
    }
    @GetMapping("/pricebetween/{start}/{finish}")
    public List<Hotel> findByPriceBetween(@PathVariable int start, @PathVariable int finish) {
        return hotelRepository.findByPriceBetween(start, finish);
    }
    @GetMapping("/hotels/names/{name}")
    public List<Hotel> findByTittleLike(@PathVariable String name) {
        return hotelRepository.findByTittleLike(name);
    }
 @GetMapping("/keywords/byPricedesc")
    public List<Hotel> findAllByPriceDesc() {
        return hotelService.findAllSQLByPriceDesc();
    }
    @PutMapping("/hotels/putPrices/{price}/{id}")
    public void setPriceById(@PathVariable int price, @PathVariable int id) {
        hotelRepository.setPriceById(id, price);
    }

}
