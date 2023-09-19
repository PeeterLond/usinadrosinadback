package com.example.usinadrosinadback.domain.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    @Query("select a from Advertisement a where a.user.id = ?1 order by a.time DESC")
    List<Advertisement> findAllUserAdvertisementsBy(Integer userId);

    @Query("select a from Advertisement a where a.county.id = ?1")
    List<Advertisement> findAdvertisementsByCounty(Integer countyId);

    @Query("select a from Advertisement a where a.city.id = ?1")
    List<Advertisement> findAdvertisementsByCity(Integer cityId);

    @Query("select a from Advertisement a where a.type.id = ?1")
    List<Advertisement> findAdvertisementsByType(Integer typeId);

    @Query("select a from Advertisement a where a.tool.id = ?1")
    List<Advertisement> findAdvertisementsByTool(Integer toolId);






}