package com.example.usinadrosinadback.domain.advertisement;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    @Resource
    private AdvertisementRepository advertisementRepository;

    public void saveAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }
}
