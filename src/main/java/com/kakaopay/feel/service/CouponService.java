package com.kakaopay.feel.service;

import com.kakaopay.feel.common.Response;
import com.kakaopay.feel.coupon.model.Coupon;

import java.util.List;

public interface CouponService {

    Response<Coupon> create(String email) throws Exception;
    Response<List<Coupon>> select(int pageNo, int take);
    Response<Coupon> select(String email);
    Response<Long> select();
}
