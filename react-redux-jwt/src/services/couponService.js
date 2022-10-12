import axios from "axios";
import authHeader from "./auth-header";

const Coupon_URL = "http://localhost:8081/";

class CouponService {
  addCoupon(couponName, couponValidity,description,couponCode,couponCategory,couponPrice,couponQuantity,couponBrand) {
    return axios.post(Coupon_URL + "couponAndDeals/create", {
      couponName,
      couponValidity,
      description,
      couponCode,
      couponCategory,
      couponPrice,
      couponQuantity,
      couponBrand
    });
  }

  getAllCoupons() {
    return axios.get(Coupon_URL + 'couponAndDeals/getAll');
  }
  deleteCoupon(couponId) {
    return axios.delete(Coupon_URL  + 'couponAndDeals/delete/' + couponId);
  }
  updateCoupon(couponAndDeals, couponId){
    return axios.put(Coupon_URL  + 'couponAndDeals/update/' + couponId, couponAndDeals);
  }
}

export default new CouponService();
