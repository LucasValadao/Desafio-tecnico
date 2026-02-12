package com.lucasvaladao.desafio.coupon.domain;

import java.time.Instant;

public class Coupon {

    private String id;
    private String code;
    private String description;
    private double discountValue;
    private Instant expirationDate;
    private boolean published;
    private boolean redeemed;
    private Status status;

    public Coupon(String code,
                  String description,
                  double discountValue,
                  Instant expirationDate,
                  boolean published) {

        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
        this.redeemed = false;
        this.status = Status.INACTIVE;

        validate();
        recalculateStatus();
    }

    private void validate() {
        if (discountValue < 0.5 ) {
            throw new IllegalArgumentException("O valor do desconto nao pode ser menor que 0,5");
        }

        if (expirationDate.isBefore(Instant.now())) {
            throw new IllegalArgumentException("Cupom nao pode ser criado expirado");
        }
    }

    public void recalculateStatus() {
        if (status == Status.DELETED) return;

        if (!published) {
            status = Status.INACTIVE;
            return;
        }

        if (expirationDate.isBefore(Instant.now())) {
            status = Status.INACTIVE;
            return;
        }

        status = Status.ACTIVE;
    }

    public boolean isExpired() {
        return expirationDate.isBefore(Instant.now());
    }

    public String getId() { return id; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public double getDiscountValue() { return discountValue; }
    public Instant getExpirationDate() { return expirationDate; }
    public boolean isPublished() { return published; }
    public boolean isRedeemed() { return redeemed; }
    public Status getStatus() { return status; }

    public void assignId(String id) {
        if (this.id != null) return;
        this.id = id;
    }

}
