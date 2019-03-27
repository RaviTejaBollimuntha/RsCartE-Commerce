package com.rscart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rscart.repository.CouponRepository;

@Service
public class CouponServicceImpl implements CouponSevice {
	@Autowired
	private CouponRepository couprepo;
	@Override
	public boolean checkCoupon(String couponvalue) {
		
		return couprepo.checkCoupon(couponvalue) ;
	}

}
