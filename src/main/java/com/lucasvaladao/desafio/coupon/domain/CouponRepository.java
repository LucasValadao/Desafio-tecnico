package com.lucasvaladao.desafio.coupon.domain;

import java.util.Optional;

public interface CouponRepository {
    public Coupon save(Coupon coupon);

    Optional<Coupon> findById(String id);
}
