package com.example.service;

import com.example.dto.CouponsDTO;
import com.example.entity.CouponAndDeals;
import com.example.exception.CouponNotFoundException;
import com.example.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;
    //Get all coupon details
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public List<CouponsDTO> getCouponAndDeals() {
        List<CouponAndDeals> couponAndDealsList = couponRepository.findAll();
        return couponAndDealsList.stream().map(CouponsDTO::new).collect(Collectors.toList());
    }

    @Override
    public CouponsDTO getCouponAndDeals(Integer id) {
        CouponAndDeals couponAndDeals=couponRepository.findById(id).orElseThrow(()-> new CouponNotFoundException("Coupon does not exist with id:"+id));
        return new CouponsDTO(couponAndDeals);
    }
//    @Override
//    public Optional<CouponsDTO> getCouponByCouponName(String couponName) {
//        return couponRepository.getCouponByCouponName(couponName);
//    }
@Override
public CouponsDTO getCouponByName(String couponName) {
    CouponAndDeals couponAndDeals = couponRepository.findByCouponName(couponName).orElseThrow();
    return new CouponsDTO(couponAndDeals);
}
    //Create new coupon
    @Override
    public CouponsDTO newCouponAndDeals(CouponsDTO couponsDTO) {
        CouponAndDeals couponAndDeals = new CouponAndDeals(couponsDTO);
        couponAndDeals.setCouponId(sequenceGeneratorService.getSequenceNumber(CouponAndDeals.SEQUENCE_NAME));
        return new CouponsDTO(couponRepository.save(couponAndDeals));
    }
    //Update Coupon
    @Override
    public CouponsDTO updateCoupon(Integer id, CouponsDTO couponsDTO) {
        CouponAndDeals couponAndDeals = couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException("Coupon does not exist with id: " + id));

        Optional<CouponAndDeals> optionalCoupon = couponRepository.findById(id);
        couponRepository.delete(couponAndDeals);

        if (optionalCoupon.isPresent()) {
            CouponAndDeals couponAndDeals1 = optionalCoupon.get();

            couponAndDeals1.setCouponId(couponAndDeals.getCouponId());
            couponAndDeals1.setCouponName(couponsDTO.getCouponName() != null ? couponsDTO.getCouponName() : couponAndDeals1.getCouponName());
            couponAndDeals1.setCouponValidity(couponsDTO.getCouponValidity() != null ? couponsDTO.getCouponValidity() : couponAndDeals1.getCouponValidity());
            couponAndDeals1.setDescription(couponsDTO.getDescription() != null ? couponsDTO.getDescription() : couponAndDeals1.getDescription());
            couponAndDeals1.setCouponCode(couponsDTO.getCouponCode() != null ? couponsDTO.getCouponCode() : couponAndDeals1.getCouponCode());


            couponRepository.save(couponAndDeals1);
            return new CouponsDTO(couponAndDeals1);
        }
        return new CouponsDTO(couponAndDeals);
    }

    //Delete coupon with given ID
    @Override
    public void deleteCouponAndDeals(Integer id) {
        CouponAndDeals couponAndDeals = couponRepository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException("Coupon does not exist with id: " + id));
        couponRepository.delete(couponAndDeals);
    }

    //Delete all coupon
    @Override
    public void deleteAll() {
        couponRepository.deleteAll();
    }
}
