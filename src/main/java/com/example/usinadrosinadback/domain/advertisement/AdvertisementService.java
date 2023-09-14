package com.example.usinadrosinadback.domain.advertisement;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AdvertisementService {

    @Resource
    private AdvertisementRepository advertisementRepository;

    public void saveAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    public Advertisement getAdvertisementBy(Integer advertisementId) {
        return advertisementRepository.getReferenceById(advertisementId);
    }

    public void deleteAdvertisement(Integer advertisementId) {
        Advertisement advertisement = advertisementRepository.getReferenceById(advertisementId);
        advertisementRepository.delete(advertisement);
    }
}
