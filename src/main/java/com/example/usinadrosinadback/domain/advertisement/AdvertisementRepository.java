package com.example.usinadrosinadback.domain.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    @Query("select a from Advertisement a where a.user.id = ?1 order by a.time DESC")
    List<Advertisement> findAllUserAdvertisementsBy(Integer userId);

    @Query("""
            select a from Advertisement a
            where (:countyId = 0 or a.county.id = :countyId)
            and (:cityId = 0 or a.city.id = :cityId)
            and (:toolId = 0 or a.tool.id = :toolId)
            and (:typeId = 0 or a.type.id = :typeId)
            order by a.time DESC""")
    List<Advertisement> findAdvertisementsBy(Integer countyId, Integer cityId, Integer toolId, Integer typeId);


}