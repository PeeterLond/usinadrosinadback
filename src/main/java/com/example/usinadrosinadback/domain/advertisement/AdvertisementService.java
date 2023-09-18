package com.example.usinadrosinadback.domain.advertisement;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Advertisement> getUserAdvertisementBy(Integer userId) {
        return advertisementRepository.findAllUserAdvertisementsBy(userId);
    }

    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public List<Advertisement> getAdvertisementsByCounty(Integer countyId) {
        return advertisementRepository.findAdvertisementsByCounty(countyId);
    }

    public List<Advertisement> getAdvertisementsByCity(Integer cityId) {
        return advertisementRepository.findAdvertisementsByCity(cityId);
    }
}
