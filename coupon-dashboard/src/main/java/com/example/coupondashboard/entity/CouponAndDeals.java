package com.example.coupondashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CouponAndDeals {
    public int couponId;

    public String couponName;

    public String couponValidity;

    public String description;

    public String couponCode;

}
