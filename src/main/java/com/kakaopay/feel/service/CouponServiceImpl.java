package com.kakaopay.feel.service;

import com.kakaopay.feel.common.Response;
import com.kakaopay.feel.common.Error;
import com.kakaopay.feel.cupon.model.Coupon;
import com.kakaopay.feel.cupon.repository.CouponRepository;
import com.kakaopay.feel.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository repository;

//    @PersistenceContext
//    EntityManager em;

    @Override
    @Transactional
    public Response<Coupon> create(String email) {
        try {

//            em.getTransaction().begin();

            Coupon coupon = repository.findByEmail(email);
            if (coupon != null) {
                return new Response<>(Error.Duplicate, Error.DuplicateName);
            }

            String couponNo = Utils.GeneratorCouponNo(email);
            Date now = Utils.getCurrentTimeStamp();
            coupon = new Coupon(email, couponNo, now);
            repository.save(coupon);
//            em.getTransaction().commit();

            Response<Coupon> response = new Response<>(200, "Success");
            response.setResult(coupon);
            return response;
        } catch (Exception e) {
//            em.getTransaction().rollback();
//            throw e;
        }
        return null;
    }

    @Override
    public Response<List<Coupon>> select(int page, int take) {
        PageRequest pageRequest = PageRequest.of(page, take, new Sort(Sort.Direction.DESC, "id"));
        List<Coupon> list = repository.findAll(pageRequest).getContent();
        Response<List<Coupon>> response = new Response<>(200, "Success");
        response.setResult(list);
        return response;
    }

    @Override
    public Response<Coupon> select(String email) {
        try {
            Coupon coupon = repository.findByEmail(email);
            Response<Coupon> response = new Response<>(200, "Success");
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
			Response<Long> response = new Response<>(200, "Success");
			response.setResult(totCnt);
			return response;
		} catch(Exception e) {
			throw e;
		}
	}
}
