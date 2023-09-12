package com.example.usinadrosinadback.business.user.contact;

import com.example.usinadrosinadback.business.user.contact.dto.ContactDto;
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
    @Operation(summary = "Uue kasutaja lisamine", description = "Pilt,linn, telefoni number ja lühitutvustus ei ole kohustuslikud väljad. Kui city id on 0 siis linna ei lisata kasutaja külge")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Selline kasutaja on juba süsteemis olemas.",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addContact(@RequestBody ContactDto request) {
        profileService.addContact(request);
    }
    @GetMapping("/contact")
    @Operation(summary = "Leiab userId järgi kasutja info.")
    public ContactDto getProfileInfo(@RequestParam Integer userId){
       return profileService.getProfileInfo(userId);
    }
}
