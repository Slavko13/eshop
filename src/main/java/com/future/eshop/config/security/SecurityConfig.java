package com.future.eshop.config.security;

import com.future.eshop.config.jwt.JwtAuthFilter;
import com.future.eshop.config.jwt.JwtTokenProvider;
import com.future.eshop.exceptions.exceptionHandler.RestAuthenticationEntryPoint;
import com.future.eshop.service.user.role.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;
    public SecurityConfig(JwtTokenProvider jwtTokenProvider, RoleService roleService, @Qualifier("userDetails") UserDetailsService userDetailsService) {
        this.roleService = roleService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preAuthenticatedAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new JwtAuthFilter(jwtTokenProvider), AbstractPreAuthenticatedProcessingFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .addFilterBefore(createRequestHeadersPreAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().disable()
                .logout().disable();
    }

    @Bean
    RestAuthenticationEntryPoint authenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/actuator/health");
//    }

    private Filter createRequestHeadersPreAuthenticationFilter() throws Exception {
        var filter = new RequestHeadersPreAuthenticationFilter(jwtTokenProvider, userDetailsService);
        filter.setAuthenticationDetailsSource(new GrantedAuthoritiesAuthenticationDetailsSource(jwtTokenProvider, roleService));
        filter.setAuthenticationManager(authenticationManager());
        filter.setContinueFilterChainOnUnsuccessfulAuthentication(false);
        return filter;
    }


    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        var preAuthProvider = new PreAuthenticatedAuthenticationProvider();
        preAuthProvider.setPreAuthenticatedUserDetailsService(
                new PreAuthenticatedGrantedAuthoritiesUserDetailsService());
        return preAuthProvider;
    }





}
