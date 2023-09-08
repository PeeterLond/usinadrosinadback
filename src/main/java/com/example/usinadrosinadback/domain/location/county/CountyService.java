package com.example.usinadrosinadback.domain.location.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {

    @Resource
    private CountyRepository countyRepository;

    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }
}
