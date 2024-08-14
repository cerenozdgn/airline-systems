package com.example.airline_systems.service;

import com.example.airline_systems.dto.AuthResponseDto;
import com.example.airline_systems.dto.LoginDto;

public interface AuthService {
    AuthResponseDto login(LoginDto loginDto) throws Exception;
}
