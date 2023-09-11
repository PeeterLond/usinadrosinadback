package com.example.usinadrosinadback.domain.location.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c from City c where c.county.id = ?1")
    List<City> getAllCitiesBy(Integer countyId);


}