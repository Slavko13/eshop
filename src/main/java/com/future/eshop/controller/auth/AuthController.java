package com.future.eshop.controller.auth;


import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.dto.user.AuthenticationRequestDto;
import com.future.eshop.dto.user.JwtAuthenticationResponse;
import com.future.eshop.dto.user.UserDTO;
import com.future.eshop.dto.user.UsernameSuggest;
import com.future.eshop.service.user.auth.AuthorizationService;
import com.future.eshop.service.user.auth.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final RegistrationService registrationService;
    private final AuthorizationService authorizationService;

    public AuthController(RegistrationService registrationService, AuthorizationService authorizationService) {
        this.registrationService = registrationService;
        this.authorizationService = authorizationService;
    }


    @PostMapping("/signUp")
    @CrossOrigin
    public EshopUser registerUser(@RequestBody UserDTO userDTO) {
        return registrationService.addUser(userDTO);
    }

    @PostMapping("/signIn")
    @CrossOrigin
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return new ResponseEntity<>(authorizationService.signIn(authenticationRequestDto), HttpStatus.OK);
    }

    @GetMapping("/generate/password")
    @CrossOrigin
    public ResponseEntity<String> generatePassword() {
        return new ResponseEntity<>(registrationService.passwordSuggest(), HttpStatus.OK);
    }

    @GetMapping("/generate/username")
    @CrossOrigin
    public ResponseEntity<UsernameSuggest> generateUsername(@RequestParam String username) {
        return new  ResponseEntity<>(registrationService.checkAndSuggestNewUsername(username), HttpStatus.OK);
    }


}
