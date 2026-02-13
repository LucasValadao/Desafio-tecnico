package com.lucasvaladao.desafio.coupon.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CouponTest {

    @Test
    void shouldCreateInactiveCouponWhenNotPublished() {

        Coupon coupon = new Coupon(
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                false
        );

        assertEquals(Status.INACTIVE, coupon.getStatus());
    }

    @Test
    void shouldCreateActiveCouponWhenPublished() {

        Coupon coupon = new Coupon(
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                true
        );

        assertEquals(Status.ACTIVE, coupon.getStatus());
    }

    @Test
    void shouldDeleteCoupon() {

        Coupon coupon = new Coupon(
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                false
        );

        coupon.delete();

        assertEquals(Status.DELETED, coupon.getStatus());
    }

    @Test
    void shouldThrowWhenDeletingAlreadyDeletedCoupon() {

        Coupon coupon = new Coupon(
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                false
        );

        coupon.delete();

        assertThrows(IllegalStateException.class,
                coupon::delete);
    }

    @Test
    void shouldThrowWhenCreatingExpiredCoupon() {

        assertThrows(IllegalArgumentException.class,
                () -> new Coupon(
                        "ABC123",
                        "desc",
                        0.5,
                        Instant.now().minusSeconds(3600),
                        false
                ));
    }

    @Test
    void shouldRestoreDeletedCoupon() {

        Coupon coupon = Coupon.restore(
                "1",
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                true,
                false,
                Status.DELETED
        );

        assertEquals(Status.DELETED, coupon.getStatus());
    }

    @Test
    void shouldThrowWhenPublishingExpiredCoupon() {

        Coupon coupon = new Coupon(
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                false
        );

        coupon = Coupon.restore(
                coupon.getId(),
                coupon.getCode(),
                "desc",
                0.5,
                Instant.now().minusSeconds(3600),
                false,
                false,
                Status.INACTIVE
        );

        assertThrows(IllegalStateException.class, coupon::publish);
    }

    @Test
    void shouldThrowWhenDiscountLowerThanZeroFive() {
        assertThrows(IllegalArgumentException.class,
                () -> new Coupon(
                        "ABC123",
                        "desc",
                        0.4,
                        Instant.now().plusSeconds(3600),
                        false
                ));
    }

    @Test
    void shouldThrowWhenMoreThanSixCharactersAfterNormalization() {
        assertThrows(IllegalArgumentException.class,
                () -> new CouponCode("ABC1234"));
    }
}
