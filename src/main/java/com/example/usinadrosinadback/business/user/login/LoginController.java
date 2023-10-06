package com.example.usinadrosinadback.business.user.login;

import com.example.usinadrosinadback.business.user.login.dto.LoginResponseDto;
import com.example.usinadrosinadback.infrastucture.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;


    @GetMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab UserId, username ja roleName",
            description = """ 
                    Süsteemist otsitakse username ja password abil kasutajat, kelle konto on ka aktiivne.
                    Kui vastet ei leita vistakse viga errorCode'ga 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Vale kasutajanimi või parool koos. errorCode: 111",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponseDto login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

    @GetMapping("/reset-password")
    @Operation(summary = "Taastab kadunud salasõna",
    description = "Kontrollib emaili järgi kas kasutaja eksisteerib. Kui ei, siis visatakse viga errorCode'ga 333." +
            "Kui jah siis genereeritakse uus suvaline salasõna mis salvestatakse kasutajale ja saadetakse tema emailile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403",
                    description = "message: Sellise emailiga kasutajat ei eksisteeri. errorCode: 333",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void resetPassword(@RequestParam String email) {
        loginService.resetPassword(email);
    }
}
