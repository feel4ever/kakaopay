package com.kakaopay.feel.cupon.controller;


import com.kakaopay.feel.common.Response;
import com.kakaopay.feel.common.Error;
import com.kakaopay.feel.cupon.model.Coupon;
import com.kakaopay.feel.service.CouponServiceImpl;
import com.kakaopay.feel.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuponController {

    @Autowired
    CouponServiceImpl service;

    @PostMapping("/coupon")
    public Response<Coupon> create(@RequestParam("email") String email) {
        return Utils.validateEmail(email)
                ? service.create(email)
                : new Response<>(400, "BadRequest");
    }

    @GetMapping("/coupon/{email}")
    public Response<Coupon> select(@PathVariable("email") String email) {
        return Utils.validateEmail(email)
                ? service.select(email)
                : new Response<>(Error.BadRequest, "BadRequest");
    }

    @GetMapping("/coupons")
    public Response<List<Coupon>> select(@RequestParam("page") int page, @RequestParam("take") int take) {
            return service.select(page, take);
    }
    
    @GetMapping("/coupons/total")
    public Response<Long> select(){
    		return service.select();
    }
    

}
