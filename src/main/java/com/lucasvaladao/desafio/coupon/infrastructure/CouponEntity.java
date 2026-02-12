package com.lucasvaladao.desafio.coupon.infrastructure;

import com.lucasvaladao.desafio.coupon.domain.Status;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "coupon")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String code;
    private String description;
    private double discountValue;
    private Instant expirationDate;
    private boolean published;
    private boolean redeemed;

    @Enumerated(EnumType.STRING)
    private Status status;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getDiscountValue() { return discountValue; }
    public void setDiscountValue(double discountValue) { this.discountValue = discountValue; }
    public Instant getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Instant expirationDate) { this.expirationDate = expirationDate; }
    public boolean isPublished() { return published; }
    public void setPublished(boolean published) { this.published = published; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public boolean isRedeemed() { return redeemed; }
    public void setRedeemed(boolean redeemed) { this.redeemed = redeemed; }
}