package com.example.controller;

import com.example.dto.CouponsDTO;
import com.example.exception.CentralExceptionHandler;
import com.example.exception.CouponNotFoundException;
import com.example.service.CouponService;
import com.example.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@ComponentScan(basePackages = "com.example.service")
@RequestMapping("/couponAndDeals")

public class CouponController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/")
    public ResponseEntity<List<CouponsDTO>> getAllDrugsData() throws CouponNotFoundException {
        List<CouponsDTO> list = couponService.getCouponAndDeals();
        if (list.isEmpty()) {
            throw new CouponNotFoundException("There are no coupons present in the database!");
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    public ResponseEntity<CouponsDTO> createCoupon(@Valid @RequestBody CouponsDTO couponsDTO) {
        return new ResponseEntity<CouponsDTO>(couponService.newCouponAndDeals(couponsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<CouponsDTO> couponsDTOList(){
        return couponService.getCouponAndDeals();
    }

    @GetMapping("/get/{id}")
    public CouponsDTO couponsDTOById(@PathVariable Integer id) {
        return couponService.getCouponAndDeals(id);
    }

//    @GetMapping("/couponName/{couponName}")
//    public ResponseEntity<CouponsDTO> getCouponByCouponName(@PathVariable("couponName") String couponName) throws CouponNotFoundException {
//        Optional<CouponsDTO> couponDataOptional = couponService.getCouponByCouponName(couponName);
//        if (couponDataOptional.isEmpty()) {
//            throw new CouponNotFoundException("No Coupon found with name: " + couponName);
//        }
//        return ResponseEntity.ok(couponDataOptional.get());
//    }
@GetMapping("/getbyname/{couponName}")
public CouponsDTO productByName(@PathVariable String couponName) {
    return couponService.getCouponByName(couponName);
}

    @PutMapping("/update/{id}")
    public ResponseEntity<CouponsDTO> update(@PathVariable Integer id, @Valid @RequestBody CouponsDTO couponsDTO) {
        return new ResponseEntity<CouponsDTO>(couponService.updateCoupon(id, couponsDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        couponService.deleteCouponAndDeals(id);
        return "Coupon with ID: " + id + " was deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        couponService.deleteAll();
        return "All Coupons were deleted successfully";
    }
}
