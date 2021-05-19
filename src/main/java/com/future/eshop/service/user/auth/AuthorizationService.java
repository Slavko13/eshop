package com.future.eshop.service.user.auth;

import com.future.eshop.dto.user.AuthenticationRequestDto;
import com.future.eshop.dto.user.JwtAuthenticationResponse;

public interface AuthorizationService {

    JwtAuthenticationResponse signIn(AuthenticationRequestDto authenticationRequestDto);


}
