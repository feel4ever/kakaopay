package com.kakaopay.feel.service;

import com.kakaopay.feel.common.Response;
import com.kakaopay.feel.cupon.model.Coupon;

import java.util.List;

public interface CouponService {

    Response<Coupon> create(String email);
    Response<List<Coupon>> select(int pageNo, int take);
    Response<Coupon> select(String email);
    Response<Long> select();
}
