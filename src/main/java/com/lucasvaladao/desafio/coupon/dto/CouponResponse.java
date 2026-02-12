package com.lucasvaladao.desafio.coupon.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lucasvaladao.desafio.coupon.domain.Coupon;
import com.lucasvaladao.desafio.coupon.domain.Status;

import java.time.Instant;

@JsonPropertyOrder({
        "id",
        "code",
        "description",
        "discountValue",
        "expirationDate",
        "status",
        "published",
        "redeemed"
})
public class CouponResponse {

    private String id;
    private String code;
    private String description;
    private double discountValue;
    private Instant expirationDate;
    private boolean published;
    private boolean redeemed;
    private Status status;

    public static CouponResponse fromDomain(Coupon coupon) {
        CouponResponse response = new CouponResponse();
        response.id = coupon.getId();
        response.code = coupon.getCode();
        response.description = coupon.getDescription();
        response.discountValue = coupon.getDiscountValue();
        response.expirationDate = coupon.getExpirationDate();
        response.status = coupon.getStatus();
        response.published = coupon.isPublished();
        response.redeemed = coupon.isRedeemed();
        return response;
    }

    public String getId() { return id; }

    public String getCode() { return code; }

    public String getDescription() { return description; }

    public double getDiscountValue() { return discountValue; }

    public Instant getExpirationDate() { return expirationDate; }

    public boolean isPublished() { return published; }

    public boolean isRedeemed() { return redeemed; }

    public Status getStatus() { return status; }
}
