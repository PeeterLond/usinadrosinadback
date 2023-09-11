package com.example.usinadrosinadback.business.location;

import com.example.usinadrosinadback.business.location.dto.CountyDto;
import com.example.usinadrosinadback.domain.location.city.CityDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class LocationController {

    @Resource
    private LocationService locationService;

    @GetMapping("/counties")
    public List<CountyDto> getCounties() {
        return locationService.getCounties();
    }

    @GetMapping("/cities")
    public List<CityDto> getCities() {
        return locationService.getCities();
    }
}
