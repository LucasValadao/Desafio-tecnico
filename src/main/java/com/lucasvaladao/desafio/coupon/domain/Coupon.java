package com.lucasvaladao.desafio.coupon.domain;

import java.time.Instant;

public class Coupon {

    private String id;
    private CouponCode code;
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
                  boolean isPublished) {

        this.code = new CouponCode(code);
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = false;
        this.redeemed = false;
        this.status = Status.INACTIVE;

        validate();

        if (isPublished) {
            publish();
        }
    }

    private void validate() {
        if (discountValue < 0.5 ) {
            throw new IllegalArgumentException("O valor do desconto nao pode ser menor que 0,5");
        }

        if (expirationDate.isBefore(Instant.now())) {
            throw new IllegalArgumentException("Cupom nao pode ser criado expirado");
        }
    }

    public void publish() {
        if (expirationDate.isBefore(Instant.now())) {
            throw new IllegalStateException("Um cupom expirado nao pode ser publicado");
        }

        this.published = true;
        this.status = Status.ACTIVE;
    }

    public String getId() { return id; }
    public String getCode() { return code.getValue(); }
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
