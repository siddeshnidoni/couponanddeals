package com.example.profileservice.controller;

//import com.example.profileservice.dto.CouponsDTO;
import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.CouponAndDeals;
import com.example.profileservice.entity.Order;
import com.example.profileservice.exception.CouponNotFoundException;
import com.example.profileservice.exception.ProfileNotFoundException;
import com.example.profileservice.security.entity.AuthenticationRequest;
import com.example.profileservice.service.ProfileService;
import com.example.profileservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/userDetails")
public class UserController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    ProfileService profileService;

    AuthenticationRequest authenticationRequest = new AuthenticationRequest();


//    @GetMapping("/username/{email}")
//    public ResponseEntity<ProfileDTO> getProfileDataByEmail(@PathVariable("email") String email) throws ProfileNotFoundException {
//
//        Optional<ProfileDTO> profileDTO = ProfileService.getProfileDataByEmail(email);
//        if (profileDTO.isEmpty()) {
//            throw new ProfileNotFoundException("No User found with email: " + email);
//        }
//        return ResponseEntity.ok(profileDTO.get());
//
//    }

    @PostMapping("/create")
    public ResponseEntity<ProfileDTO> createProfileDetails(@Valid @RequestBody ProfileDTO profileDTO){
        return new ResponseEntity<ProfileDTO>(profileService.newProfileDetails(profileDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getbymail/{emailId}")
    public ProfileDTO customerBymail(@PathVariable String emailId) {
    return profileService.getByMail(emailId);
}
    @PutMapping("/profileDetails/update/{id}")
    public ResponseEntity<ProfileDTO> updateProfile(@RequestBody ProfileDTO profileDTO ,
                                                    @PathVariable("id") int profileId){
        ProfileDTO updatedProfileDetails = profileService.updateProfile(profileDTO,profileId);
        return  ResponseEntity.ok(updatedProfileDetails);
    }

    //Fetching All Coupons from CouponAndDeals for Users
    @GetMapping("/couponAndDeals/getAll")
    public CouponAndDeals[] getCouponAndDeals() throws CouponNotFoundException {
        ResponseEntity<CouponAndDeals[]> response =
                restTemplate.getForEntity("http://Coupon-And-Deals/couponAndDeals/getAll", CouponAndDeals[].class);
        CouponAndDeals[] couponAndDeals = response.getBody();
        return (couponAndDeals);
    }

    //Fetching A Coupon by name from CouponAndDeals for Users
    @GetMapping("/couponName/{couponName}")
    public CouponAndDeals getCouponByCouponName(@PathVariable("couponName")String couponName) {

        return restTemplate.getForObject("http://Coupon-And-Deals/couponAndDeals/couponName/" + couponName, CouponAndDeals.class);
    }

    //***********************Ordering Coupon*****************************



    @RequestMapping("/order")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) throws CouponNotFoundException {

        Order order1 =new Order(order.getId(), order.getCost(),order.getDate(),order.getQuantity(),
                order.getCouponName(),order.getUserName(),order.getUserEmail());
        String s = restTemplate.postForObject("http://Order-Info-Service/order/save", order1, String.class);
        String s1 = s+ authenticationRequest.getUsername();
        return ResponseEntity.ok(s);
    }
}
