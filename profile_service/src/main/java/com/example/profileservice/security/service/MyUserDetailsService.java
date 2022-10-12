package com.example.profileservice.security.service;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.ProfileDetails;
import com.example.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles = null;
        Optional<ProfileDetails> profileDetails = profileRepository.findByMail(emailId);
        if (profileDetails == null) {
            throw new UsernameNotFoundException(emailId);
        }
        else {

            if (emailId.equals("admin"))
            {
                roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new User("admin", "admin", roles);
            }

            else
            {
                String username = profileDetails.get().getEmail();
                String password = profileDetails.get().getPassword();
                roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
                return new User(username, password, roles);
            }
        }
    }
}