package com.example.usinadrosinadback.domain.location.coordinate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface CoordinateRepository extends JpaRepository<Coordinate, Integer> {
    @Query("select c from Coordinate c where c.longField = ?1 and c.lat = ?2")
    Coordinate getCoordinateBy(BigDecimal longField, BigDecimal lat);


}