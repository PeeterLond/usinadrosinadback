package com.example.usinadrosinadback.business.user.contact;

import com.example.usinadrosinadback.business.user.contact.dto.ContactCreateAndEditDto;
import com.example.usinadrosinadback.business.user.contact.dto.ContactShowInfoDto;
import com.example.usinadrosinadback.infrastucture.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Resource
    private ProfileService profileService;

    @PostMapping("/contact")
    @Operation(summary = "Uue kasutaja lisamine",
            description = "Pilt,linn, telefoni number ja lühitutvustus ei ole kohustuslikud väljad. " +
                    "Kui city id on 0 siis linna ei lisata kasutaja külge")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Selline kasutaja on juba süsteemis olemas.",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addContact(@RequestBody ContactCreateAndEditDto request) {
        profileService.addContact(request);
    }

    @GetMapping("/contact")
    @Operation(summary = "Leiab userId järgi kasutja info ning kuvab info, mida on võimalik redigeerida.",
            description = "Puudub userName, cityName ja countyName (nende asemel on cityId ja countyId).")
    public ContactCreateAndEditDto getContactInfoForEdit(@RequestParam Integer userId) {
        return profileService.getContactInfoForEdit(userId);
    }

    @GetMapping("/contact-show")
    @Operation(summary = "Leiab userId järgi kasutaja info dashboard vaates.",
    description = "On olemas lisaks userName, countyName ja cityName (countyId ja cityId puuduvad).")
    public ContactShowInfoDto getContactInfoForShow(@RequestParam Integer userId){
        return profileService.getContactInfoForShow(userId);
    }

    @PutMapping("/contact")
    @Operation(summary = "Olemasoleva kasutaja info muutmine",
            description = "Kui foto on olemas, siis kirjutab üle olemasoleva foto, ei lisa uut fotot andmebaasi")
    public void updateContactInfo(@RequestParam Integer userId, @RequestBody ContactCreateAndEditDto request) {
        profileService.updateContactInfo(userId, request);
    }

}
