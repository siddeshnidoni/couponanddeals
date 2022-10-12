package com.example.profileservice.service;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.ProfileDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfileService {

    List<ProfileDTO> getProfileDetails();
    ProfileDTO getProfileDetails(Integer id);

    ProfileDTO newProfileDetails(ProfileDTO profileDTO);


    //Update Coupon
    ProfileDTO updateProfile(ProfileDTO profileDTO,Integer id);

//    public Optional<ProfileDetails> getProfileDataByEmail(String email);

    ProfileDTO getByMail(String emailId);
    void deleteProfileDetails(Integer id);
    void deleteAll();

}



