package com.lucasvaladao.desafio.coupon.application;

import com.lucasvaladao.desafio.coupon.domain.*;
import com.lucasvaladao.desafio.coupon.dto.CreateCouponRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateCouponService {

    private final CouponRepository repository;

    public CreateCouponService(CouponRepository repository) {
        this.repository = repository;
    }

    public Coupon execute(CreateCouponRequest request) {
        boolean published = request.getPublished() != null
                ? request.getPublished()
                : false;

        Coupon coupon = new Coupon(
                request.getCode(),
                request.getDescription(),
                request.getDiscountValue(),
                request.getExpirationDate(),
                published
        );

        return repository.save(coupon);
    }
}
