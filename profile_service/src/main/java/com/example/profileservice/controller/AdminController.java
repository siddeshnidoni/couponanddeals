package com.example.profileservice.controller;

//import com.example.profileservice.dto.CouponsDTO;
import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.CouponAndDeals;
import com.example.profileservice.exception.CouponNotFoundException;
import com.example.profileservice.exception.ProfileNotFoundException;
import com.example.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProfileService profileService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/profileDetails/getAll")
    public ResponseEntity<List<ProfileDTO>> getProfileDetails() throws ProfileNotFoundException {
        List<ProfileDTO> list = profileService.getProfileDetails();
        if (list.isEmpty()) {
            throw new ProfileNotFoundException("There are no Profile present in the database!");
        }
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/profileDetails/delete/{id}")
    public void deleteProfileDetails(@PathVariable("id") int profileId) throws ProfileNotFoundException
    {
        Optional<ProfileDTO> profileDTO = Optional.ofNullable(profileService.getProfileDetails(profileId));
        if(profileDTO.isEmpty()) {
            throw new ProfileNotFoundException("No Profile found with id " + profileId);
        }
        profileService.deleteProfileDetails(profileId);
    }

    //*******************************************Coupons******************************************************************

    //saving coupons by admin
    @PostMapping("/couponAndDetails/create")
    public ResponseEntity<CouponAndDeals> newCouponAndDeals(@RequestBody CouponAndDeals couponAndDeals) {


        CouponAndDeals couponAndDeals1 = new CouponAndDeals(couponAndDeals.getCouponId(),couponAndDeals.getCouponName(), couponAndDeals.getCouponValidity(),couponAndDeals.getDescription(), couponAndDeals.getCouponCode(), couponAndDeals.getCouponCategory(),couponAndDeals.getCouponPrice(),couponAndDeals.getCouponQuantity(),couponAndDeals.getCouponBrand());
        CouponAndDeals response =
                restTemplate.postForObject("http://Coupon-And-Deals/couponAndDeals/create", couponAndDeals1, CouponAndDeals.class);
        return ResponseEntity.ok(response);

    }
    //deleting any coupon by admin
    @DeleteMapping("/couponAndDetails/delete/{id}")
    public String delete(@PathVariable("id") int couponId) throws  Exception{

        if(couponId != 0){
            restTemplate.delete("http://Coupon-And-Deals/couponAndDeals/delete/" + couponId);
            return "Deleted Successfully";
        }
        else {
            throw new Exception("No Id Found");
        }

    }

    //getting all the coupon by admin
    @GetMapping("/couponAndDetails/getAll")
    public CouponAndDeals[] couponAndDeals() throws CouponNotFoundException {
        ResponseEntity<CouponAndDeals[]> response =
                restTemplate.getForEntity("http://Coupon-And-Deals/couponAndDeals/getAll", CouponAndDeals[].class);
        CouponAndDeals[] couponAndDeals = response.getBody();
        return (couponAndDeals);
    }

    //getting Coupons by id for admin
    @GetMapping("/couponAndDetails/get/{id}")
    public CouponAndDeals getCouponAndDeals(@PathVariable("id") int couponId) throws CouponNotFoundException{
        return restTemplate.getForObject("http://Coupon-And-Deals/couponAndDeals/get/" +couponId, CouponAndDeals.class);

    }

    //updating any coupon data by admin
    @PutMapping("/couponAndDetails/update/{id}")
    public CouponAndDeals update(@RequestBody CouponAndDeals couponAndDeals,
                                     @PathVariable("id") int couponId) {
        RequestEntity<CouponAndDeals> request = RequestEntity
                .put("http://Coupon-And-Deals/couponAndDeals/update/"+couponId)
                .accept(MediaType.APPLICATION_JSON)
                .body(couponAndDeals);
        ResponseEntity<CouponAndDeals> response = restTemplate.exchange(request,CouponAndDeals.class);
        CouponAndDeals couponAndDeals1=response.getBody();
        return couponAndDeals1;
    }







}