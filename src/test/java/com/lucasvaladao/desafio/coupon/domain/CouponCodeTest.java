package com.lucasvaladao.desafio.coupon.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CouponCodeTest {

    @Test
    void shouldRemoveSpecialCharacters() {
        CouponCode code = new CouponCode("ABC-123");
        assertEquals("ABC123", code.getValue());
    }

    @Test
    void shouldConvertToUpperCase() {
        CouponCode code = new CouponCode("abc123");
        assertEquals("ABC123", code.getValue());
    }

    @Test
    void shouldThrowWhenLessThanSixCharactersAfterNormalization() {
        assertThrows(IllegalArgumentException.class,
                () -> new CouponCode("A-B"));
    }

    @Test
    void shouldThrowWhenNullOrBlank() {
        assertThrows(IllegalArgumentException.class,
                () -> new CouponCode(""));
    }

}
