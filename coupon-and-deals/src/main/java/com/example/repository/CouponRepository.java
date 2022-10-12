package com.example.repository;

import com.example.dto.CouponsDTO;
import com.example.entity.CouponAndDeals;
import com.example.entity.CouponAndDeals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;

/*
public interface CouponRepository extends JpaRepository<CouponAndDeals, Integer> {

}
*/
@Repository
public interface CouponRepository extends MongoRepository<CouponAndDeals, Integer> {
//    Optional<CouponsDTO> getCouponByCouponName(String couponName);
    Optional<CouponAndDeals> findByCouponName(String couponName);
}
