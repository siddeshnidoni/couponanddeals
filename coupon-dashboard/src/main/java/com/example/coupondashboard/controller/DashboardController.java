package com.example.coupondashboard.controller;

import com.example.coupondashboard.entity.CouponAndDeals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/getById/{couponId}")
    public CouponAndDeals getProduct(@PathVariable("couponId")Integer couponId) {

        return restTemplate.getForObject("http://Coupon-And-Deals/couponAndDeals/get/" + couponId, CouponAndDeals.class);
    }


    @RequestMapping("/all")
    public CouponAndDeals[] getAllTheCoupons(){
        ResponseEntity<CouponAndDeals[]> response =
                restTemplate.getForEntity("http://Coupon-And-Deals/couponAndDeals/getAll", CouponAndDeals[].class);
        CouponAndDeals[] couponAndDeals = response.getBody();
        return (couponAndDeals);
    }

}
