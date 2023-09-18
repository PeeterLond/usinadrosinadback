package com.example.usinadrosinadback.domain.advertisementChore;

import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdvertisementChoreRepository extends JpaRepository<AdvertisementChore, Integer> {
    @Query("select a from AdvertisementChore a where a.chore.id = ?1 and a.advertisement.id = ?2")
    AdvertisementChore findAdvertisementChoreBy(Integer choreId, Integer advertisementId);

    @Query("select a from AdvertisementChore a where a.advertisement.id = ?1")
    List<AdvertisementChore> findAllBy(Integer advertisementId);

    @Query("select a from AdvertisementChore a where a.advertisement.id = ?1")
    List<AdvertisementChore> getAdvertisementChoresBy(Integer advertisementId);






}