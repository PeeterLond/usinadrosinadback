package com.example.usinadrosinadback.business.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementDto;
import com.example.usinadrosinadback.business.advertisement.dto.ChoreDto;
import com.example.usinadrosinadback.business.advertisement.dto.ToolDto;
import com.example.usinadrosinadback.business.advertisement.dto.TypeDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    @Resource
    private AdService adService;

    @GetMapping("/chore")
    @Operation(summary = "Toob kõik teenused tabelist")
    public List<ChoreDto> getAllChores() {
        return adService.getAllChores();
    }

    @GetMapping("/type")
    @Operation(summary = "Toob kõik kuulutuse tüübid tabelist")
    public List<TypeDto> getAllAdvertisementTypes() {
        return adService.getAllAdvertisementTypes();
    }

    @GetMapping("/tool")
    @Operation(summary = "Toob kõik kuulutuse vahendid tabelist")
    public List<ToolDto> getAdvertisementTools() {
        return adService.getAllAdvertisementTools();
    }

    @PostMapping("/advertisement")
    @Operation(summary = "Uue kuulutuse lisamine kasutajale. Tagastab kuulutuse id.",
            description = "Kui koordinaate ei tule frondist, siis väärtus null. Lisatakse juurde timeStamp. " +
                    "Linn, koordinaadid ja pindala võivad olla tühjad.")
    public Integer addAdvertisement(@RequestBody AdvertisementDto request) {
        return adService.addAdvertisement(request);
    }
}
