package com.burpee.security;

import com.burpee.entities.User;
import com.burpee.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
Clase que actúa como puente entre UserDetailsService de Spring SEcurity
y nuestro UserRepository o un DAO o la clase que tengamos para sacar
el usuario de base de datos

Patrón Adapter
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username + " not found!")
        );

        return new CustomUserDetails(user);
    }
}
