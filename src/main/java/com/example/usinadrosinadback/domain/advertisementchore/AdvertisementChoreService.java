package com.example.usinadrosinadback.domain.advertisementchore;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementChoreService {

    @Resource
    private AdvertisementChoreRepository advertisementChoreRepository;

    public void saveAdvertisementChore(AdvertisementChore advertisementChore) {
        advertisementChoreRepository.save(advertisementChore);
    }

    public void deleteAdvertisementChore(Integer choreId, Integer advertisementId) {
        AdvertisementChore advertisementChore =
                advertisementChoreRepository.findAdvertisementChoreBy(choreId, advertisementId);
        advertisementChoreRepository.delete(advertisementChore);
    }

    public void deleteAllAdvertisementsChores(Integer advertisementId) {
        List<AdvertisementChore> allAdvertisementChores = advertisementChoreRepository.findAllBy(advertisementId);
        advertisementChoreRepository.deleteAllInBatch(allAdvertisementChores);
    }

    public List<AdvertisementChore> getAdvertisementChoresBy(Integer advertisementId) {
        return advertisementChoreRepository.getAdvertisementChoresBy(advertisementId);
    }

    public boolean checkIfAdvertisementChoresExists(Integer advertisementId) {
        return advertisementChoreRepository.existsByAdvertisement_Id(advertisementId);
    }
}
