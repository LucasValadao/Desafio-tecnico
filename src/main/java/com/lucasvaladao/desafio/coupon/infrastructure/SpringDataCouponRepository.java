package com.lucasvaladao.desafio.coupon.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCouponRepository extends JpaRepository<CouponEntity, String> {
}