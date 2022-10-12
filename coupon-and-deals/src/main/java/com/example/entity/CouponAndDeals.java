package com.example.entity;

import com.example.dto.CouponsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

//import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("coupondb")


//@Entity
//@Table(name = "coupon_table")
public class CouponAndDeals {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

//    @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int couponId;
//    @Column(name = "coupon_name")
    public String couponName;
//    @Column(name = "coupon_Validity")
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//  @Column(name = "Exp_Date")
    public LocalDate couponValidity;
//    @Column(name = "coupon_Description")
    public String description;
//    @Column(name = "coupon_Code")
    public String couponCode;
    public String couponCategory;

    public double couponPrice;

    public int couponQuantity;
    public String couponBrand;


    public CouponAndDeals(CouponsDTO couponsDTO){
        this.couponId = couponsDTO.getCouponId();
        this.couponName = couponsDTO.getCouponName();
        this.couponValidity = couponsDTO.getCouponValidity();
        this.description = couponsDTO.getDescription();
        this.couponCode = couponsDTO.getCouponCode();
        this.couponCategory=couponsDTO.getCouponCategory();
        this.couponPrice=couponsDTO.getCouponPrice();
        this.couponQuantity=couponsDTO.getCouponQuantity();
        this.couponBrand=couponsDTO.getCouponBrand();

    }


}

