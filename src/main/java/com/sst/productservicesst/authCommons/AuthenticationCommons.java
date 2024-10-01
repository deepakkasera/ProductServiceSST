package com.sst.productservicesst.authCommons;

import com.sst.productservicesst.dtos.UserDto;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {
    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        UserDto userDto = restTemplate.getForObject(
                "http://localhost:4141/users/validate/" + token,
                UserDto.class
        );

        return userDto;
    }
}
