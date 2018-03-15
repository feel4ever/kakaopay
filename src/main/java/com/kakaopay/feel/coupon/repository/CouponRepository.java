package com.kakaopay.feel.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kakaopay.feel.coupon.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Coupon findByEmail(String eamil);
}
