package com.example.airline_systems.service.impl;

import com.example.airline_systems.dto.AuthResponseDto;
import com.example.airline_systems.dto.LoginDto;
import com.example.airline_systems.enums.Role;
import com.example.airline_systems.model.User;
import com.example.airline_systems.repository.UserRepository;
import com.example.airline_systems.security.JwtTokenProvider;
import com.example.airline_systems.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initializeUser() {
        if(!userRepository.existsByUsername("user")){
            var user = User.builder().username("user")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.USER).build();
            userRepository.save(user);
        }
    }
    private AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public AuthResponseDto login(LoginDto loginDto) throws Exception {
        User user =  userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        if(passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            var jwtToken = jwtTokenProvider.generateToken(user);
            return AuthResponseDto.builder()
                    .accessToken(jwtToken)
                    .build();
        }

       throw new Exception("Username or password is wrong");
    }

}
