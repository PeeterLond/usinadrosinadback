package com.example.usinadrosinadback.business.location;

import com.example.usinadrosinadback.business.location.dto.CountyDto;
import io.swagger.v3.oas.annotations.Operation;
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
}
