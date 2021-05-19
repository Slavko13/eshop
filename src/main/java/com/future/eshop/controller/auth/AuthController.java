package com.future.eshop.controller.auth;


import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.dto.user.AuthenticationRequestDto;
import com.future.eshop.dto.user.JwtAuthenticationResponse;
import com.future.eshop.dto.user.UserDTO;
import com.future.eshop.service.user.auth.AuthorizationService;
import com.future.eshop.service.user.auth.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
@Controller
public class AuthController {

    private final RegistrationService registrationService;
    private final AuthorizationService authorizationService;

    public AuthController(RegistrationService registrationService, AuthorizationService authorizationService) {
        this.registrationService = registrationService;
        this.authorizationService = authorizationService;
    }


    @PostMapping("/signUp")
    public EshopUser registerUser(@RequestBody UserDTO userDTO) {
        return registrationService.addUser(userDTO);
    }

    @PostMapping("/signIn")
    public JwtAuthenticationResponse signIn(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return authorizationService.signIn(authenticationRequestDto);
    }



}
