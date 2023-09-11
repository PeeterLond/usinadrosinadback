package com.example.usinadrosinadback.business.location;

import com.example.usinadrosinadback.business.location.dto.CountyDto;
import com.example.usinadrosinadback.business.location.dto.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LocationController {

    @Resource
    private LocationService locationService;

    @GetMapping("/counties")
    @Operation(summary = "Maakonnad. Tagastab maakondade listi")
    public List<CountyDto> getCounties() {
        return locationService.getCounties();
    }

    @GetMapping("/cities")
    @Operation(summary = "Linnad. Tagastab linnade listi vastavalt maakonna Id-le")
    public List<CityDto> getCities(@RequestParam Integer countyId) {
        return locationService.getCitiesBy(countyId);
    }
}
