package com.lucasvaladao.desafio.coupon.controller;

import com.lucasvaladao.desafio.coupon.application.CreateCouponService;
import com.lucasvaladao.desafio.coupon.dto.CouponResponse;
import com.lucasvaladao.desafio.coupon.dto.CreateCouponRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CreateCouponService service;

    public CouponController(CreateCouponService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> create(@Valid @RequestBody CreateCouponRequest request) {
        var createdCoupon = service.execute(request);

        return ResponseEntity.ok(CouponResponse.fromDomain(createdCoupon));
    }
}
