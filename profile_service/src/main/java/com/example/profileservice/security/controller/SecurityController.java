package com.example.profileservice.security.controller;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.ProfileDetails;
import com.example.profileservice.security.entity.AuthenticationRequest;
import com.example.profileservice.security.entity.AuthenticationResponse;
import com.example.profileservice.security.service.MyUserDetailsService;
import com.example.profileservice.security.util.JwtUtil;
import com.example.profileservice.service.ProfileService;
import com.example.profileservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    ProfileService profileService;

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

//    @PostMapping("/signup")
//    public ResponseEntity<ProfileDetails> newProfileDetails(@RequestBody ProfileDetails profileDetails)  {
//        profileDTO.setProfileId((sequenceGeneratorService.getSequenceNumber(ProfileDetails.SEQUENCE_NAME)));
//        ProfileDetails savedProfileDetails = profileService.newProfileDetails(profileDetails);
//        return ResponseEntity.ok(savedProfileDetails);
//    }
//    //@CrossOrigin("http://localhost:3000")
//    @RequestMapping(value="/auth/signin", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
//            throws Exception {
//
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
//                    (authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect Username or Password", e);
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
@RequestMapping(value="/authenticate", method = RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
        throw new Exception("Incorrect Username or Password", e);
    }
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
}

}