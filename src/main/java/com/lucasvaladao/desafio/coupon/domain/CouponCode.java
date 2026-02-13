package com.lucasvaladao.desafio.coupon.domain;

public class CouponCode {

    private final String value;

    public CouponCode(String rawCode) {

        if (rawCode == null || rawCode.isBlank()) {
            throw new IllegalArgumentException("Codigo do cupom nao pode ser nulo ou vazio");
        }

        String normalized = normalize(rawCode);

        if (normalized.length() != 6) {
            throw new IllegalArgumentException("Codigo do cupom deve ter 6 digitos");
        }

        this.value = normalized;
    }

    private String normalize(String input) {
        return input
                .replaceAll("[^a-zA-Z0-9]", "")
                .toUpperCase();
    }

    public String getValue() {
        return value;
    }
}
