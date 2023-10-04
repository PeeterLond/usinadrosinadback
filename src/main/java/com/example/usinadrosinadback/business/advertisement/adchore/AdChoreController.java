package com.example.usinadrosinadback.business.advertisement.adchore;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementChoreDto;
import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementChoreShowDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdChoreController {

    @Resource
    private AdChoreService adChoreService;

    @GetMapping("/advertisement-chore-exists")
    @Operation(summary = "Tagastab true kui kuulutusel on olemas teenused.")
    public ResponseEntity<Boolean> checkAdvertisementChoresExists(@RequestParam Integer advertisementId) {
        return ResponseEntity.ok(adChoreService.checkIfAdvertisementChoresExists(advertisementId));
    }

    @GetMapping("/advertisement-chore")
    @Operation(summary = "Tagastab kuulutuse teenuse tüübid vastavalt kuulutuse id-le")
    public List<AdvertisementChoreShowDto> getAdvertisementChoresBy(@RequestParam Integer advertisementId) {
        return adChoreService.getAdvertisementChoresBy(advertisementId);
    }

    @PostMapping("/advertisement-chore")
    @Operation(summary = "Uue teenuse lisamine kuulutusele.")
    public void addAdvertisementChore(@RequestBody AdvertisementChoreDto request) {
        adChoreService.addAdvertisementChore(request);
    }

    @DeleteMapping("/advertisement-chore")
    @Operation(summary = "Kustutab kuulutuse teenuste tabelist ära vastava teenuse.",
            description = "Otsib kuulutuse teenuse vastavalt kuulutuse ja teenuse Id-de järgi ja kustutab vastava kuulutuse teenuse")
    public void deleteAdvertisementChore(@RequestParam Integer choreId, @RequestParam Integer advertisementId) {
        adChoreService.deleteAdvertisementChore(choreId, advertisementId);
    }

    @DeleteMapping("/advertisement-chores")
    @Operation(summary = "Kustutab kõik kuulutuse teenused.",
            description = "Kustutab kõik kuulutuse teenused mida kasutaja valis kui kasutaja  vajutas kuulutuse teenuste lisamisel katkesta nuppu")
    public void deleteAllAdvertisementChores(@RequestParam Integer advertisementId) {
        adChoreService.deleteAllAdvertisementChores(advertisementId);
    }

}
