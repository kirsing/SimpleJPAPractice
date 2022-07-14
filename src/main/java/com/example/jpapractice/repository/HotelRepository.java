package com.example.jpapractice.repository;

import com.example.jpapractice.model.Hotel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    public List<Hotel> findByIdOrPriceGreaterThan(Integer id, Integer price);

    @Query(nativeQuery = true, value = "SELECT * FROM hotels_table where hotel_id = ?1 or rent_price >=?2")
    public List<Hotel> findByIdOrPriceGreaterThansql(Integer id, Integer price);

    @Query(nativeQuery = true, value = "SELECT * FROM hotels_table where hotel_id =:id or rent_price >=:price")
    public List<Hotel> findByIdOrPriceGreaterThansqlParam(@Param("id")Integer id, @Param("price") Integer price);

    @Query(value = "SELECT h FROM Hotel h where h.id = ?1 or h.price >=?2")
    public List<Hotel> findByIdOrPriceGreaterThanjpql(Integer id, Integer price);

    @Query(nativeQuery = true, value = "SELECT * FROM hotels_table h where h.rent_price BETWEEN ?1 AND ?2")
    public List<Hotel> findByPriceBetween(Integer start, Integer finish);

    @Query(nativeQuery = true, value = "SELECT * FROM hotels_table h where h.hotel_name LIKE %?1%")
    public List<Hotel> findByTittleLike(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE hotels_table SET rent_price =:price WHERE hotel_id =:id")
    public void setPriceById(Integer id, Integer price);
}
