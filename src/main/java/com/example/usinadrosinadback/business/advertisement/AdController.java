package com.example.usinadrosinadback.business.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AdController {

    @Resource
    private AdService adService;


    @GetMapping("/advertisement")
    @Operation(summary = "Tagastab kuulutuse info vastavalt tema id-le")
    public AdvertisementDto getAdvertisementBy(@RequestParam Integer advertisementId) {
        return adService.getAdvertisementBy(advertisementId);
    }

    @PutMapping("/advertisement")
    @Operation(summary = "Kasutaja kuulutuse muutmine")
    public void updateAdvertisement(@RequestParam Integer advertisementId, @RequestBody AdvertisementDto request) {
        adService.updateAdvertisement(advertisementId, request);
    }

    @GetMapping("/chore")
    @Operation(summary = "Tagastab kõik teenused tabelist")
    public List<ChoreDto> getAllChores() {
        return adService.getAllChores();
    }

    @GetMapping("/type")
    @Operation(summary = "Tagastab kõik kuulutuse tüübid tabelist")
    public List<TypeDto> getAllAdvertisementTypes() {
        return adService.getAllAdvertisementTypes();
    }

    @GetMapping("/tool")
    @Operation(summary = "Tagastab kõik kuulutuse vahendid tabelist")
    public List<ToolDto> getAdvertisementTools() {
        return adService.getAllAdvertisementTools();
    }

    @GetMapping("/advertisement-with-contact")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga.")
    public List<AdvertisementContactShowDto> getAllAdvertisementsWithContact() {
        return adService.getAllAdvertisementsWithContact();
    }

    @GetMapping("/advertisement-user-with-contact")
    @Operation(summary = "Tagastab kõik kasutaja kuulutused koos tema kasutaja infoga vastavalt tema Id-le.")
    public List<AdvertisementContactShowDto> getUserAdvertisementsWithContactBy(@RequestParam Integer userId) {
        return adService.getUserAdvertisementsWithContactBy(userId);
    }

    @GetMapping("/advertisement-with-contact-by-county")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga vastavalt maakonna järgi")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByCounty(@RequestParam Integer countyId) {
        return adService.getAdvertisementsWithContactByCounty(countyId);
    }

    @GetMapping("/advertisement-with-contact-by-city")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga vastavalt linna järgi")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByCity(@RequestParam Integer cityId) {
        return adService.getAdvertisementsWithContactByCity(cityId);
    }

    @GetMapping("/advertisement-with-contact-by-type")
    @Operation(summary = "Tagastab kõik kuulutused vastavalt tema tüübile")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByType(@RequestParam Integer typeId) {
        return adService.getAdvertisementsWithContactByType(typeId);
    }

    @GetMapping("/advertisement-with-contact-by-tool")
    @Operation(summary = "Tagastab kõik kuulutused vastavalt vahenditele")
    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByTool(@RequestParam Integer toolId) {
        return adService.getAdvertisementsWithContactByTool(toolId);
    }

    @PostMapping("/advertisement")
    @Operation(summary = "Uue kuulutuse lisamine kasutajale. Tagastab kuulutuse id.",
            description = "Kui koordinaate ei tule frondist, siis väärtus null. Lisatakse juurde timeStamp. " +
                    "Linn, koordinaadid ja pindala võivad olla tühjad.")
    public ResponseEntity<Integer> addAdvertisement(@RequestBody AdvertisementDto request) {
        return ResponseEntity.ok(adService.addAdvertisement(request));

    }

    @DeleteMapping("/advertisement")
    @Operation(summary = "Kustutab kuulutuse", description = "Kustutab kuulutuse kui kasutaja vajutas kuulutuse lisamise ajal katkesta.")
    public void deleteAdvertisement(@RequestParam Integer advertisementId) {
        adService.deleteAdvertisement(advertisementId);
    }
}
