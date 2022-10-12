package com.example.dto;

import com.example.entity.CouponAndDeals;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class CouponsDTO {

        private int couponId;

//        @NotBlank(message = "Coupon name cannot be blank or null")
//        @Size(min = 4, max = 20)
        private String couponName;

//        @NotBlank(message = "Validity must be entered")
//        @Size(min = 3, max = 20)
        private LocalDate couponValidity;

//        @NotBlank(message = "Description cannot be blank or null")
//        @Size(min = 3, max = 40)
        private String description;

//        @NotBlank(message = "Coupon Code cannot be blank or null")
//        @Size(min = 3, max = 20)
        private String couponCode;

//        @NotBlank(message = "Category cannot be blank or null")
//        @Size(min = 3, max = 40)
        private String couponCategory;

//        @NotBlank(message = "Brand cannot be blank or null")
//        @Size(min = 3, max = 40)

        private double couponPrice;

        public int couponQuantity;
        private String couponBrand;


        public CouponsDTO(CouponAndDeals couponAndDeals) {
            this.couponId = couponAndDeals.getCouponId();
            this.couponName = couponAndDeals.getCouponName();
            this.couponValidity = couponAndDeals.getCouponValidity();
            this.description = couponAndDeals.getDescription();
            this.couponCode = couponAndDeals.getCouponCode();
            this.couponCategory=couponAndDeals.getCouponCategory();
            this.couponPrice=couponAndDeals.getCouponPrice();
            this.couponQuantity=couponAndDeals.getCouponQuantity();
            this.couponBrand=couponAndDeals.getCouponBrand();
        }
    }




