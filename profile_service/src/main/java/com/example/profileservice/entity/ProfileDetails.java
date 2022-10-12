package com.example.profileservice.entity;

import com.example.profileservice.dto.ProfileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="profiledb")


public class ProfileDetails {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    public int profileId;

    public String firstName;

    public String lastName;

    public String email;

    public String password;

    public String address;

    public String contactNumber;


    public ProfileDetails(ProfileDTO profileDTO){
        this.profileId = profileDTO.getProfileId();
        this.firstName = profileDTO.getFirstName();
        this.lastName = profileDTO.getLastName();
        this.email = profileDTO.getEmail();
        this.password = profileDTO.getPassword();
        this.address = profileDTO.getAddress();
        this.contactNumber = profileDTO.getContactNumber();

    }


}

