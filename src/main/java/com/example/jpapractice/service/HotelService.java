package com.example.jpapractice.service;


import com.example.jpapractice.model.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Repository
public class HotelService {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public void deleteById(int id) {
        Hotel selectedHotel = entityManager.find(Hotel.class, id);
        entityManager.lock(selectedHotel, LockModeType.OPTIMISTIC);
        entityManager.remove(selectedHotel);
    }

    @Transactional
    public void delete(Hotel hotel) {
        entityManager.remove(hotel);
    }

    public List<Hotel> findAllSQL() {
        return entityManager.createNativeQuery("SELECT * FROM hotels_table", Hotel.class).getResultList();
    }

    public List<Hotel> findAllJPQL() {
        return entityManager.createQuery("FROM hotels_table", Hotel.class).getResultList();
    }

    public List<Hotel> getCriteriaHotels() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);
        Root<Hotel> hotelRoot = criteriaQuery.from(Hotel.class);
        criteriaQuery.select(hotelRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<String> getCriteriaHotelsNames() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Hotel> houseRoot = criteriaQuery.from(Hotel.class);
        criteriaQuery.select(houseRoot.get("name"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Integer getCriteriaHotelSumPrices() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<Hotel> houseRoot = criteriaQuery.from(Hotel.class);
        criteriaQuery.select(criteriaBuilder.sum(houseRoot.get("price")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
