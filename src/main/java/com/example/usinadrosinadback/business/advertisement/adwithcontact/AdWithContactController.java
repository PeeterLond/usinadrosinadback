package com.example.usinadrosinadback.business.advertisement.adwithcontact;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementContactShowDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdWithContactController {

    @Resource
    private AdWithContactService adWithContactService;


    @GetMapping("/advertisement-with-contact")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga.")
    public List<AdvertisementContactShowDto> getAllAdvertisementsWithContact() {
        return adWithContactService.getAllAdvertisementsWithContact();
    }

    @GetMapping("/advertisement-user-with-contact")
    @Operation(summary = "Tagastab kõik kasutaja kuulutused koos tema kasutaja infoga vastavalt tema Id-le.")
    public List<AdvertisementContactShowDto> getUserAdvertisementsWithContactBy(@RequestParam Integer userId) {
        return adWithContactService.getUserAdvertisementsWithContactBy(userId);
    }

    @GetMapping("/advertisement-with-contact-filter")
    @Operation(summary = "Tagastab kuulutused vastavalt valitud filtritele",
            description = "Ignoreerib vastavat filtrit kui selle väärtus on 0.")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactBy(@RequestParam Integer countyId,
                                                                            @RequestParam Integer cityId,
                                                                            @RequestParam Integer toolId,
                                                                            @RequestParam Integer typeId) {
        return adWithContactService.getAdvertisementsWithContactBy(countyId, cityId, toolId, typeId);
    }
}
