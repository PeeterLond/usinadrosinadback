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

    @PostMapping("/advertisement")
    @Operation(summary = "Uue kuulutuse lisamine kasutajale. Tagastab kuulutuse id.",
            description = "Kui koordinaate ei tule frondist, siis väärtus null. Lisatakse juurde timeStamp. " +
                    "Linn, koordinaadid ja pindala võivad olla tühjad.")
    public ResponseEntity<Integer> addAdvertisement(@RequestBody AdvertisementDto request) {
        return ResponseEntity.ok(adService.addAdvertisement(request));

    }

    @PutMapping("/advertisement")
    @Operation(summary = "Kasutaja kuulutuse muutmine")
    public void updateAdvertisement(@RequestParam Integer advertisementId, @RequestBody AdvertisementDto request) {
        adService.updateAdvertisement(advertisementId, request);
    }

    @DeleteMapping("/advertisement")
    @Operation(summary = "Kustutab kuulutuse", description = "Kustutab kuulutuse kui kasutaja vajutas kuulutuse lisamise ajal katkesta.")
    public void deleteAdvertisement(@RequestParam Integer advertisementId) {
        adService.deleteAdvertisement(advertisementId);
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

}
