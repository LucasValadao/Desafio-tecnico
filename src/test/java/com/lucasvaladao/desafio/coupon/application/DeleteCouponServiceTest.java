package com.lucasvaladao.desafio.coupon.application;

import com.lucasvaladao.desafio.coupon.domain.Coupon;
import com.lucasvaladao.desafio.coupon.domain.CouponRepository;
import com.lucasvaladao.desafio.coupon.domain.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteCouponServiceTest {
    @Mock
    private CouponRepository repository;

    @InjectMocks
    private DeleteCouponService service;

    @Test
    void shouldDeleteCoupon() {

        Coupon coupon = new Coupon(
                "ABC123",
                "desc",
                0.5,
                Instant.now().plusSeconds(3600),
                false
        );

        when(repository.findById("1")).thenReturn(Optional.of(coupon));

        service.execute("1");

        assertEquals(Status.DELETED, coupon.getStatus());
        verify(repository).save(coupon);
    }
}
