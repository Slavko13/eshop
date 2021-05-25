package com.future.eshop.service.user.auth;

import com.future.eshop.config.jwt.JwtTokenProvider;
import com.future.eshop.dto.user.AuthenticationRequestDto;
import com.future.eshop.dto.user.JwtAuthenticationResponse;
import com.future.eshop.exceptions.simpleException.BadRequestException;
import com.future.eshop.exceptions.simpleException.NotFoundException;
import com.future.eshop.repository.user.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthorizationServiceImpl(JwtTokenProvider jwtTokenProvider, UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public JwtAuthenticationResponse signIn(AuthenticationRequestDto authenticationRequestDto) {
        var user = userRepo.findByUsername(authenticationRequestDto.getUsername()).orElseThrow(()-> new NotFoundException("{AuthorizationServiceImpl.signIn.NotFoundByEmail}"));

        //TODO:
        //        if((passwordEncoder.matches(authenticationRequestDto.getPassword(), user.getPassword()))) {
//            throw new BadRequestException("{AuthServiceImpl.signIn.IncorrectPassword}");
//        }

        String token = jwtTokenProvider.generateToken(user);
        return new JwtAuthenticationResponse(token);
    }

}
