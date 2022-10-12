package com.example.OrderService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document("coupondb")


public class CouponAndDeals {
//    @Transient
//    public static final String SEQUENCE_NAME = "users_sequence";

//    @Id
//    private int couponId;

    private String couponName;

    private LocalDate couponValidity;

    private String description;

    private String couponCode;
    private String couponCategory;
    private double couponPrice;
    private int couponQuantity;
    private String couponBrand;
}

