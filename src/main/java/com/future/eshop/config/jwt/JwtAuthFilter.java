package com.future.eshop.config.jwt;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
public class JwtAuthFilter extends GenericFilter {


    private final JwtTokenProvider jwtTokenProvider;
    public static final String AUTHORIZATION = "Authorization";

    public JwtAuthFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken(((HttpServletRequest) servletRequest).getHeader(AUTHORIZATION));

        boolean tokenStatus = jwtTokenProvider.validateToken(token);
        if ( token!=null && !tokenStatus) {
            ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }




}
