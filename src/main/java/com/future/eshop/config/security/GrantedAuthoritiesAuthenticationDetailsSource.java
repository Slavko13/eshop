package com.future.eshop.config.security;

import com.future.eshop.config.jwt.JwtTokenProvider;
import com.future.eshop.domain.user.Authority;
import com.future.eshop.domain.user.Role;
import com.future.eshop.exceptions.simpleException.UnauthorizedException;
import com.future.eshop.service.user.role.RoleService;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class GrantedAuthoritiesAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails> {

    private final JwtTokenProvider jwtTokenProvider;
    private final RoleService roleService;

    public GrantedAuthoritiesAuthenticationDetailsSource(JwtTokenProvider jwtTokenProvider, RoleService roleService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.roleService = roleService;
    }

    public static final String AUTHORIZATION = "Authorization";
    public static final String ROLE_GUEST = "ROLE_GUEST";



    @Override
    public PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails buildDetails(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request.getHeader(AUTHORIZATION));

        if (token == null ) {
            Role guestRole = roleService.getRoleByName("ROLE_GUEST");
            var authoritiesNames = guestRole.getAuthorities().stream().map(Authority::getName).collect(Collectors.toList());
            return new PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(request, getAuthorities(authoritiesNames));
        }
        if (!jwtTokenProvider.validateToken(token)) {
            throw new UnauthorizedException("{Invalid Token}");
        }

        var authorities = getAuthorities(jwtTokenProvider.getAllAuthorities(token));
        return new PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(request, authorities);
    }

    private List<GrantedAuthority> getAuthorities(List<String> authorities) {
        return  authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }






}
