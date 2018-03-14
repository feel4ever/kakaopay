package com.kakaopay.feel.cupon.repository;

import com.kakaopay.feel.cupon.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Coupon findByEmail(String eamil);
}
