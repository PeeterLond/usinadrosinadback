package com.example.usinadrosinadback.domain.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    @Query("select a from Advertisement a where a.user.id = ?1 order by a.time DESC")
    List<Advertisement> findAllUserAdvertisementsBy(Integer userId);


}