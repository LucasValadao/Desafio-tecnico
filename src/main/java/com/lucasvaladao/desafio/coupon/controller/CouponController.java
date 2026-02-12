package com.lucasvaladao.desafio.coupon.controller;

import com.lucasvaladao.desafio.coupon.application.CreateCouponService;
import com.lucasvaladao.desafio.coupon.application.DeleteCouponService;
import com.lucasvaladao.desafio.coupon.application.GetCouponService;
import com.lucasvaladao.desafio.coupon.domain.CouponRepository;
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
    private final DeleteCouponService deleteService;

    public CouponController(CreateCouponService createService, GetCouponService getService, DeleteCouponService deleteService) {
        this.createService = createService;
        this.getService = getService;
        this.deleteService = deleteService;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        deleteService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
