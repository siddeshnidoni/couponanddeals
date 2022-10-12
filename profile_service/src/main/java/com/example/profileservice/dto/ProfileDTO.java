package com.example.profileservice.dto;

import com.example.profileservice.entity.CouponAndDeals;
import com.example.profileservice.entity.ProfileDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

    private int profileId;

    @NotBlank(message = "FirstName must be entered")
    @Size(min = 3, max = 20)
    private String firstName;

    @NotBlank(message = "LastName must be entered")
    @Size(min = 3, max = 20)
    private String lastName;

    @NotBlank(message = "Email cannot be blank or null")
    @Size(min = 3, max = 40)
    private String email;

    @NotBlank(message = "Password cannot be blank or null")
    @Size(min = 3, max = 40)
    private String password;

    @NotBlank(message = "Address cannot be blank or null")
    @Size(min = 3, max = 40)
    private String address;

    @NotBlank(message = "Contact cannot be blank or null")
    @Size(min = 9, max = 10)
    private String contactNumber;



    public ProfileDTO(ProfileDetails profileDetails) {
        this.profileId = profileDetails.getProfileId();
        this.firstName = profileDetails.getFirstName();
        this.lastName = profileDetails.getLastName();
        this.email = profileDetails.getEmail();
        this.password = profileDetails.getPassword();
        this.address = profileDetails.getAddress();
        this.contactNumber = profileDetails.getContactNumber();
    }

}




