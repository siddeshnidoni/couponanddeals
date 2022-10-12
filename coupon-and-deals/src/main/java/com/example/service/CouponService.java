package com.example.service;

import com.example.dto.CouponsDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CouponService {

    List<CouponsDTO> getCouponAndDeals();
    CouponsDTO getCouponAndDeals(Integer id);


    CouponsDTO newCouponAndDeals(CouponsDTO couponsDTO);

    //CouponsDTO updateCouponAndDeals(Integer id, CouponsDTO couponsDTO);

//    public Optional<CouponsDTO> getCouponByCouponName(String couponName);
    //Update Coupon
    CouponsDTO getCouponByName(String couponName);
    CouponsDTO updateCoupon(Integer id, CouponsDTO couponsDTO);

    void deleteCouponAndDeals(Integer id);
    void deleteAll();

}
