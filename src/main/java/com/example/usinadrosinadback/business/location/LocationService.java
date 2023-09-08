package com.example.usinadrosinadback.business.location;

import com.example.usinadrosinadback.business.location.dto.CountyDto;
import com.example.usinadrosinadback.domain.location.county.County;
import com.example.usinadrosinadback.domain.location.county.CountyMapper;
import com.example.usinadrosinadback.domain.location.county.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Resource
    private CountyService countyService;
    @Resource
    private CountyMapper countyMapper;

    public List<CountyDto> getCounties() {
        List<County> counties = countyService.getAllCounties();
        return countyMapper.toCountyDtos(counties);
    }
}
