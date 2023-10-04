package com.example.usinadrosinadback.domain.advertisementchore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementChoreRepository extends JpaRepository<AdvertisementChore, Integer> {
    @Query("select a from AdvertisementChore a where a.chore.id = ?1 and a.advertisement.id = ?2")
    AdvertisementChore findAdvertisementChoreBy(Integer choreId, Integer advertisementId);

    @Query("select a from AdvertisementChore a where a.advertisement.id = ?1")
    List<AdvertisementChore> findAllBy(Integer advertisementId);

    @Query("select a from AdvertisementChore a where a.advertisement.id = ?1")
    List<AdvertisementChore> getAdvertisementChoresBy(Integer advertisementId);

    @Query("select (count(a) > 0) from AdvertisementChore a where a.advertisement.id = ?1")
    boolean existsByAdvertisement_Id(Integer id);






}