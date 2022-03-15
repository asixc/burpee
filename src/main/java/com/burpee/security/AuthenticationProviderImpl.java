package com.burpee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/*
Nuestras clases:
- User
- UserRepository

Clases equivalentes en Spring Security:
- UserDetails
- UserDetailsService

Solución implementar las clases de Spring Security:
- CustomUserDetails ✅
- CustomUserDetailsService ✅
 */

/*
Esta clase hace la autenticación!
Pero es Spring quien la invoca cuando se envía una petición al backend
Se ejecuta antes de llegar a un endpoint de nuestros controladores
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserDetailsService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();

        UserDetails user = this.service.loadUserByUsername(username);
        String encodedPassword = user.getPassword();

        if(isValidPassword(rawPassword, encodedPassword))
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        else
            throw new BadCredentialsException("Bad credentials");
    }

    private boolean isValidPassword(String rawPassword, String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /*
    Comprueba que se soporta este tipo de autenticación para saber cuándo usar esta clase
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}









