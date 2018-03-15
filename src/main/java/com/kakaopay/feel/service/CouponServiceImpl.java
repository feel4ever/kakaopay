package com.kakaopay.feel.service;

import com.kakaopay.feel.common.Response;
import com.kakaopay.feel.coupon.model.Coupon;
import com.kakaopay.feel.coupon.repository.CouponRepository;
import com.kakaopay.feel.common.ComnCode;
import com.kakaopay.feel.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository repository;


    @Override
    @Transactional
    public Response<Coupon> create(String email) {
    		try {

            Coupon coupon = repository.findByEmail(email);
            if (coupon != null) {
                return new Response<>(ComnCode.Duplicate, ComnCode.DuplicateName);
            }

            String couponNo = Utils.GeneratorCouponNo(email);
            Date now = Utils.getCurrentTimeStamp();
            coupon = new Coupon(email, couponNo, now);
            repository.save(coupon);
 
            Response<Coupon> response = new Response<>(ComnCode.Success, ComnCode.SuccessName);
            response.setResult(coupon);
            return response;
        } catch (Exception e) {		
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return null;
      }
   }

    @Override
    public Response<List<Coupon>> select(int page, int take) {
    		try {
	        PageRequest pageRequest = PageRequest.of(page, take, new Sort(Sort.Direction.DESC, "id"));
	        List<Coupon> list = repository.findAll(pageRequest).getContent();
	        Response<List<Coupon>> response = new Response<>(ComnCode.Success, ComnCode.SuccessName);
	        response.setResult(list);
	        return response;
	    	} catch (Exception e) {
	    		throw e;
	    	}
    }

    @Override
    public Response<Coupon> select(String email) {
        try {
            Coupon coupon = repository.findByEmail(email);
            Response<Coupon> response = new Response<>(ComnCode.Success, ComnCode.SuccessName);
            response.setResult(coupon);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

	@Override
	public Response<Long> select() {
		// TODO Auto-generated method stub
		try {
			Long totCnt = repository.count();
			Response<Long> response = new Response<>(ComnCode.Success, ComnCode.SuccessName);
			response.setResult(totCnt);
			return response;
		} catch(Exception e) {
			throw e;
		}
	}
}
