package com.example.usinadrosinadback.business.advertisement.adChore;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementChoreDto;
import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementChoreShowDto;
import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementService;
import com.example.usinadrosinadback.domain.advertisement.chore.Chore;
import com.example.usinadrosinadback.domain.advertisement.chore.ChoreService;
import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChore;
import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChoreMapper;
import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChoreService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdChoreService {

    @Resource
    private ChoreService choreService;

    @Resource
    private AdvertisementService advertisementService;

    @Resource
    private AdvertisementChoreService advertisementChoreService;

    @Resource
    private AdvertisementChoreMapper advertisementChoreMapper;


    public boolean checkIfAdvertisementChoresExists(Integer advertisementId) {
        return advertisementChoreService.checkIfAdvertisementChoresExists(advertisementId);
    }

    public List<AdvertisementChoreShowDto> getAdvertisementChoresBy(Integer advertisementId) {
        List<AdvertisementChore> advertisementChores = advertisementChoreService.getAdvertisementChoresBy(advertisementId);
        return advertisementChoreMapper.toArvertisementChoreDtos(advertisementChores);
    }

    @Transactional
    public void addAdvertisementChore(AdvertisementChoreDto request) {
        AdvertisementChore advertisementChore = new AdvertisementChore();
        getAndSetChoreToAdvertisementChore(request, advertisementChore);
        getAndSetAdvertisementToAdvertisementChore(request, advertisementChore);
        advertisementChoreService.saveAdvertisementChore(advertisementChore);
    }

    public void deleteAdvertisementChore(Integer choreId, Integer advertisementId) {
        advertisementChoreService.deleteAdvertisementChore(choreId, advertisementId);
    }

    public void deleteAllAdvertisementChores(Integer advertisementId) {
        advertisementChoreService.deleteAllAdvertisementsChores(advertisementId);
    }

    private void getAndSetChoreToAdvertisementChore(AdvertisementChoreDto request, AdvertisementChore advertisementChore) {
        Chore chore = choreService.getChoreBy(request.getChoreId());
        advertisementChore.setChore(chore);
    }

    private void getAndSetAdvertisementToAdvertisementChore(AdvertisementChoreDto request, AdvertisementChore advertisementChore) {
        Advertisement advertisement = advertisementService.getAdvertisementBy(request.getAdvertisementId());
        advertisementChore.setAdvertisement(advertisement);
    }
}
