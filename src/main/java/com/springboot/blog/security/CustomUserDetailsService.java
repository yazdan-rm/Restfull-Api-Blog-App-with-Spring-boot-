package com.springboot.blog.security;

import com.springboot.blog.model.Role;
import com.springboot.blog.model.User;
import com.springboot.blog.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail).
                orElseThrow(() -> new UsernameNotFoundException(
                        "User not found with username or email: " + usernameOrEmail
                ));

//        Set<GrantedAuthority> grantedAuthorities = user.
//                getRoles().
//                stream().
//                map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());


        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                getAuthorities(user.getRoles()));
    }

    // instead of code at line 36 until 39 you can use below code
    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }
}
