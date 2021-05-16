package com.future.eshop.config.security;

import com.future.eshop.config.jwt.JwtTokenProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

@Order(2)
public class RequestHeadersPreAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;



    public static final String AUTHORIZATION = "Authorization";


    public RequestHeadersPreAuthenticationFilter(JwtTokenProvider jwtTokenProvider, @Qualifier("userDetails") UserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
        String token = jwtTokenProvider.resolveToken(httpServletRequest.getHeader(AUTHORIZATION));
        if (token == null) {
            return "GUEST";
        }

        boolean tokenStatus = jwtTokenProvider.validateToken(token);
        if (!tokenStatus) {
            return "GUEST";
        }
        return userDetailsService.loadUserByUsername(jwtTokenProvider.getLoginFromToken(token));
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return StringUtils.EMPTY;
    }





}

