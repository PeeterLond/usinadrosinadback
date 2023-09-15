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

    @GetMapping("/advertisement-user")
    @Operation(summary = "Tagastab kõik kasutaja kuulutused vastavalt tema Id-le.")
    public List<AdvertisementContactShowDto> getUserAdvertisementBy(@RequestParam Integer userId) {
        return adService.getUserAdvertisementBy(userId);
    }

    @GetMapping("/advertisement-with-contact")
    @Operation(summary = "Tagastab kõik kuulutused koos kasutaja infoga.")
    public List<AdvertisementContactShowDto> getAllAdvertisementsWithContact() {
        return adService.getAllAdvertisementsWithContact();
    }

    @PostMapping("/advertisement")
    @Operation(summary = "Uue kuulutuse lisamine kasutajale. Tagastab kuulutuse id.",
            description = "Kui koordinaate ei tule frondist, siis väärtus null. Lisatakse juurde timeStamp. " +
                    "Linn, koordinaadid ja pindala võivad olla tühjad.")
    public ResponseEntity<Integer> addAdvertisement(@RequestBody AdvertisementDto request) {
        return ResponseEntity.ok(adService.addAdvertisement(request));

    }

    @PostMapping("/advertisement-chore")
    @Operation(summary = "Uue teenuse lisamine kuulutusele.")
    public void addAdvertisementChore(@RequestBody AdvertisementChoreDto request) {
        adService.addAdvertisementChore(request);
    }

    @DeleteMapping("/advertisement-chore")
    @Operation(summary = "Kustutab kuulutuse teenuste tabelist ära vastava teenuse.",
            description = "Otsib kuulutuse teenuse vastavalt kuulutuse ja teenuse Id-de järgi ja kustutab vastava kuulutuse teenuse")
    public void deleteAdvertisementChore(@RequestParam Integer choreId, @RequestParam Integer advertisementId) {
        adService.deleteAdvertisementChore(choreId, advertisementId);
    }

    @DeleteMapping("/advertisement-chores")
    @Operation(summary = "Kustutab kõik kuulutuse teenused.",
            description = "Kustutab kõik kuulutuse teenused mida kasutaja valis kui kasutaja  vajutas kuulutuse teenuste lisamisel katkesta nuppu")
    public void deleteAllAdvertisementChores(@RequestParam Integer advertisementId) {
        adService.deleteAllAdvertisementChores(advertisementId);
    }

    @DeleteMapping("/advertisement")
    @Operation(summary = "Kustutab kuulutuse", description = "Kustutab kuulutuse kui kasutaja vajutas kuulutuse lisamise ajal katkesta.")
    public void deleteAdvertisement(@RequestParam Integer advertisementId) {
        adService.deleteAdvertisement(advertisementId);
    }
}
