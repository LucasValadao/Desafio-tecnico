package com.lucasvaladao.desafio.coupon.infrastructure;

import com.lucasvaladao.desafio.coupon.domain.*;
import org.springframework.stereotype.Repository;

@Repository
public class CouponRepositoryJpa implements CouponRepository {

    private final SpringDataCouponRepository jpaRepository;

    public CouponRepositoryJpa(SpringDataCouponRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Coupon save(Coupon coupon) {

        CouponEntity entity = new CouponEntity();
        entity.setId(coupon.getId());
        entity.setCode(coupon.getCode());
        entity.setDescription(coupon.getDescription());
        entity.setDiscountValue(coupon.getDiscountValue());
        entity.setExpirationDate(coupon.getExpirationDate());
        entity.setPublished(coupon.isPublished());
        entity.setRedeemed(coupon.isRedeemed());
        entity.setStatus(coupon.getStatus());

        CouponEntity saved = jpaRepository.save(entity);

        coupon.assignId(saved.getId());

        return coupon;
    }
}
