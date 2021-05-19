package com.future.eshop.service.user.auth;

import com.future.eshop.config.jwt.JwtTokenProvider;
import com.future.eshop.dto.user.AuthenticationRequestDto;
import com.future.eshop.dto.user.JwtAuthenticationResponse;
import com.future.eshop.exceptions.simpleException.BadRequestException;
import com.future.eshop.repository.user.UserRepo;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepo userRepo;

    public AuthorizationServiceImpl(JwtTokenProvider jwtTokenProvider, UserRepo userRepo) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepo = userRepo;
    }


    @Override
    public JwtAuthenticationResponse signIn(AuthenticationRequestDto authenticationRequestDto) {
        var user = userRepo.findByUsername(authenticationRequestDto.getUsername()).get();
        if(!user.getPassword().equals(authenticationRequestDto.getPassword())) {
            throw  new BadRequestException("{AuthServiceImpl.signIn.IncorrectPassword}");
        }
        String token = jwtTokenProvider.generateToken(user);
        return new JwtAuthenticationResponse(token);
    }

}
