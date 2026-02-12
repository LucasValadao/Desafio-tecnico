package com.lucasvaladao.desafio.coupon.application;

import com.lucasvaladao.desafio.coupon.domain.Coupon;
import com.lucasvaladao.desafio.coupon.domain.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCouponService {
    private final CouponRepository repository;

    public GetCouponService(CouponRepository repository) {
        this.repository = repository;
    }

    public Coupon execute(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cupom nao encontrado"));
    }
}
