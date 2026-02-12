package com.lucasvaladao.desafio.coupon.dto;

import jakarta.validation.constraints.*;
import java.time.Instant;

public class CreateCouponRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String description;

    @DecimalMin(value = "0.5", inclusive = false)
    private double discountValue;

    @NotNull
    private Instant expirationDate;

    private Boolean published;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getDiscountValue() { return discountValue; }
    public void setDiscountValue(double discountValue) { this.discountValue = discountValue; }
    public Instant getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Instant expirationDate) { this.expirationDate = expirationDate; }
    public Boolean getPublished() { return published; }
    public void setPublished(Boolean published) { this.published = published; }
}
