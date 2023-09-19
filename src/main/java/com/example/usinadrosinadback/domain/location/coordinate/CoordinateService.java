package com.example.usinadrosinadback.domain.location.coordinate;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CoordinateService {

    @Resource
    private CoordinateRepository coordinateRepository;

    public void saveCoordinate(Coordinate coordinate) {
        coordinateRepository.save(coordinate);
    }

    public Coordinate getCoordinateBy(BigDecimal coordinateLongField, BigDecimal coordinateLat) {
        return coordinateRepository.getCoordinateBy(coordinateLongField, coordinateLat);
    }
}
