package com.example.usinadrosinadback.domain.location.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public List<City> getAllCitiesBy(Integer countyId) {

       return cityRepository.getAllCitiesBy(countyId);
    }

    public City getCityBy(Integer cityId) {
        return cityRepository.getReferenceById(cityId);
    }
}
