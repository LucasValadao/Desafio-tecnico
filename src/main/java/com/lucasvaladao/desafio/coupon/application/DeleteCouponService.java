package com.lucasvaladao.desafio.coupon.application;

import com.lucasvaladao.desafio.coupon.domain.Coupon;
import com.lucasvaladao.desafio.coupon.domain.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCouponService {

        private final CouponRepository repository;

        public DeleteCouponService(GetCouponService getService, CouponRepository repository) {
            this.repository = repository;
        }

        public void execute(String id) {
            Coupon coupon = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cupom nao encontrado"));

            coupon.delete();

            repository.save(coupon);
        }
}
