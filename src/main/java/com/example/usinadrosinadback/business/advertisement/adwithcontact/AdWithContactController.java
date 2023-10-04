package com.example.usinadrosinadback.business.advertisement.adwithcontact;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementContactShowDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/advertisement-with-contact-by-county")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga vastavalt maakonna järgi")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByCounty(@RequestParam Integer countyId) {
        return adWithContactService.getAdvertisementsWithContactByCounty(countyId);
    }

    @GetMapping("/advertisement-with-contact-by-city")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga vastavalt linna järgi")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByCity(@RequestParam Integer cityId) {
        return adWithContactService.getAdvertisementsWithContactByCity(cityId);
    }

    @GetMapping("/advertisement-with-contact-by-type")
    @Operation(summary = "Tagastab kõik kuulutused vastavalt tema tüübile")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByType(@RequestParam Integer typeId) {
        return adWithContactService.getAdvertisementsWithContactByType(typeId);
    }

    @GetMapping("/advertisement-with-contact-by-tool")
    @Operation(summary = "Tagastab kõik kuulutused vastavalt vahenditele")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByTool(@RequestParam Integer toolId) {
        return adWithContactService.getAdvertisementsWithContactByTool(toolId);
    }

}
