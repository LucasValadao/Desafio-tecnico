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

    public static Coupon restore(String id,
                                 String code,
                                 String description,
                                 double discountValue,
                                 Instant expirationDate,
                                 boolean published,
                                 boolean redeemed,
                                 Status status) {

        Coupon coupon = new Coupon();

        coupon.id = id;
        coupon.code = new CouponCode(code);
        coupon.description = description;
        coupon.discountValue = discountValue;
        coupon.expirationDate = expirationDate;
        coupon.published = published;
        coupon.redeemed = redeemed;
        coupon.status = status;

        return coupon;
    }

    private Coupon() {

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

    public void delete() {

        if (this.status == Status.DELETED) {
            throw new IllegalStateException("Cupom ja foi deletado");
        }

        this.status = Status.DELETED;
    }

    public void assignId(String id) {
        if (this.id != null) return;
        this.id = id;
    }

    public String getId() { return id; }
    public String getCode() { return code.getValue(); }
    public String getDescription() { return description; }
    public double getDiscountValue() { return discountValue; }
    public Instant getExpirationDate() { return expirationDate; }
    public boolean isPublished() { return published; }
    public boolean isRedeemed() { return redeemed; }
    public Status getStatus() { return status; }
}
