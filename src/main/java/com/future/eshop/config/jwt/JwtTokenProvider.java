package com.future.eshop.config.jwt;

import com.future.eshop.domain.user.Authority;
import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.domain.user.Role;
import com.future.eshop.service.user.role.RoleService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long validityInMilliseconds;

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public JwtTokenProvider(PasswordEncoder passwordEncoder, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String generateToken(EshopUser user) {

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole() );
        claims.put("userID", user.getUserID());
        claims.put("authorities", getAuthoritiesName(user.getRole().getAuthorities()));
        claims.put("username", user.getUsername());


        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(generateTokenRole(claims, user))
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }


    public String resolveToken(String token) {

        if (token != null && token.startsWith("Bearer")) {
            return token.substring(7, token.length());
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        }
        catch(Throwable throwable) {
            return false;
        }
    }

    public Role getRoles(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String role = claims.get("role").toString();
        return roleService.getRoleByName(role);
    }


    public List<String> getAllAuthorities(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return (List<String>) claims.get("authorities");
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private List<String> getAuthoritiesName(List<Authority> userAuthority) {
        List<String> result = new ArrayList<>();
        userAuthority.forEach(
                authority -> { result.add(authority.getName()); });
        return result;
    }

    private Claims generateTokenRole(Claims claims, EshopUser user) {
        return claims;
    }




}
