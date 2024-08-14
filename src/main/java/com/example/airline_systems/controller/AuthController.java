package com.example.airline_systems.controller;

import com.example.airline_systems.dto.AuthResponseDto;
import com.example.airline_systems.dto.LoginDto;
import com.example.airline_systems.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api-token-auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) throws Exception {
        return new ResponseEntity<>(authService.login(loginDto), HttpStatus.OK);
    }

}
