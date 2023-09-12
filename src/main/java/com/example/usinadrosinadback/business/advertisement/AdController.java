package com.example.usinadrosinadback.business.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdController {

    @Resource
    private AdService adService;

    @PostMapping("/advertisement")
    @Operation(summary = "Uue kuulutuse lisamine kasutajale. Tagastab kuulutuse id.",
            description = "Kui koordinaate ei tule frondist, siis väärtus null. Lisatakse juurde timeStamp. " +
                    "Linn, koordinaadid ja pindala võivad olla tühjad.")
    public Integer addAdvertisement(@RequestBody AdvertisementDto request) {
        return adService.addAdvertisement(request);
    }

}
