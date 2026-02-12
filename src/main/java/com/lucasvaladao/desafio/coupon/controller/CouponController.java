package com.lucasvaladao.desafio.coupon.controller;

import com.lucasvaladao.desafio.coupon.application.CreateCouponService;
import com.lucasvaladao.desafio.coupon.application.GetCouponService;
import com.lucasvaladao.desafio.coupon.dto.CouponResponse;
import com.lucasvaladao.desafio.coupon.dto.CreateCouponRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CreateCouponService createService;
    private final GetCouponService getService;

    public CouponController(CreateCouponService createService, GetCouponService getService) {
        this.createService = createService;
        this.getService = getService;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> create(@Valid @RequestBody CreateCouponRequest request) {
        var createdCoupon = createService.execute(request);

        return ResponseEntity.ok(CouponResponse.fromDomain(createdCoupon));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponResponse> getById(@PathVariable("id") String id) {
        var coupon = getService.execute(id);
        return ResponseEntity.ok(CouponResponse.fromDomain(coupon));
    }
}
