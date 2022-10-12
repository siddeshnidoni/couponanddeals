package com.example.profileservice.entity;

//import com.example.profileservice.dto.CouponsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

//import javax.persistence.*;


//@Document("coupondb")


//@Entity
//@Table(name = "coupon_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponAndDeals {
//    @Transient
 public static final String SEQUENCE_NAME = "users_sequence";

    //    @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
    private int couponId;
    //    @Column(name = "coupon_name")
    private String couponName;
    //    @Column(name = "coupon_Validity")
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//  @Column(name = "Exp_Date")
    private LocalDate couponValidity;
    //    @Column(name = "coupon_Description")
    private String description;
    //    @Column(name = "coupon_Code")
    private String couponCode;
    private String couponCategory;

   private double couponPrice;

   private int couponQuantity;
   private String couponBrand;



}

