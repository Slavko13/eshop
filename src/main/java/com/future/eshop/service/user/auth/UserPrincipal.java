package com.future.eshop.service.user.auth;

import com.future.eshop.domain.user.Authority;
import com.future.eshop.domain.user.EshopUser;
import com.future.eshop.domain.user.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private final String password;
    private final String username;
    private final Set<GrantedAuthority> authorities;
    private final boolean enabled;

    public UserPrincipal(EshopUser eshopUser) {
        this.password = eshopUser.getPassword();
        this.username = eshopUser.getUsername();
        this.authorities = eshopUser.getRole().getAuthorities()
                .stream().map(this::getGrantedAuthority).collect(Collectors.toSet());;
        this.enabled = eshopUser.getUserStatus().equals(UserStatus.ACTIVE);
    }

    private SimpleGrantedAuthority getGrantedAuthority(Authority authority) {
        return new SimpleGrantedAuthority(authority.getName());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



}
