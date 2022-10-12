package com.example.profileservice.service;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.ProfileDetails;
import com.example.profileservice.exception.ProfileNotFoundException;
import com.example.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    //Get all coupon details
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public List<ProfileDTO> getProfileDetails() {
        List<ProfileDetails> profileDetailsList = profileRepository.findAll();
        return profileDetailsList.stream().map(ProfileDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getProfileDetails(Integer id) {
    ProfileDetails profileDetails=profileRepository.findById(id).orElseThrow(()-> new ProfileNotFoundException("Profile does not exist with id:"+id));
        return new ProfileDTO(profileDetails);
}

    //Create new profile
    @Override
    public ProfileDTO newProfileDetails(ProfileDTO profileDTO) {
        ProfileDetails profileDetails = new ProfileDetails(profileDTO);
        profileDetails.setProfileId(sequenceGeneratorService.getSequenceNumber(ProfileDetails.SEQUENCE_NAME));
//        profileDetails.setCouponAndDeals(couponInfo.getCouponDetails(profileDetails.getCouponId()));
        return new ProfileDTO(profileRepository.save(profileDetails));
    }
    //Update Profile
    @Override
    public ProfileDTO updateProfile(ProfileDTO profileDTO,Integer id) {
        ProfileDetails profileDetails = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile does not exist with id: " + id));

        Optional<ProfileDetails> optionalProfileDetails = profileRepository.findById(id);
        profileRepository.delete(profileDetails);

        if (optionalProfileDetails.isPresent()) {
            ProfileDetails profileDetails1 = optionalProfileDetails.get();

            profileDetails1.setProfileId(profileDetails.getProfileId());
            profileDetails1.setFirstName(profileDTO.getFirstName() != null ? profileDTO.getFirstName() : profileDetails1.getFirstName());
            profileDetails1.setLastName(profileDTO.getLastName() != null ? profileDTO.getLastName() : profileDetails1.getLastName());
            profileDetails1.setEmail(profileDTO.getEmail() != null ? profileDTO.getEmail() : profileDetails1.getEmail());
            profileDetails1.setPassword(profileDTO.getPassword() != null ? profileDTO.getPassword() : profileDetails1.getPassword());
            profileDetails1.setAddress(profileDTO.getAddress() != null ? profileDTO.getAddress() : profileDetails1.getAddress());
            profileDetails1.setContactNumber(profileDTO.getContactNumber() != null ? profileDTO.getContactNumber() : profileDetails1.getContactNumber());

//            profileDetails1.setCouponId(profileDTO.getCouponId() != 0 ? profileDTO.getCouponId() : profileDetails1.getCouponId());
//            profileDetails1.setCouponAndDeals(couponInfo.getCouponDetails(profileDetails1.getCouponId()));
            profileRepository.save(profileDetails1);
            return new ProfileDTO(profileDetails1);
        }
        return new ProfileDTO(profileDetails);
    }

    //Delete Profile with given ID
    @Override
    public void deleteProfileDetails(Integer id) {
        ProfileDetails profileDetails = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile does not exist with id: " + id));
        profileRepository.delete(profileDetails);
    }

    //Delete all profile
    @Override
    public void deleteAll() {
        profileRepository.deleteAll();
    }

//    @Override
//    public Optional<ProfileDetails> getProfileDataByEmail(String email) {
//        return profileRepository.getProfileDataByEmail(email);
//    }

    @Override
    public ProfileDTO getByMail(String email) {
        // TODO Auto-generated method stub
        ProfileDetails profileDetails = profileRepository.findByMail(email).orElseThrow(() -> new ProfileNotFoundException("User Does Not Exist With Given Mail : "+email));

        return new ProfileDTO(profileDetails);
    }
}
