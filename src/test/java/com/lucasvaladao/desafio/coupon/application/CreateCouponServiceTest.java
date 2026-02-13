package com.lucasvaladao.desafio.coupon.application;

import com.lucasvaladao.desafio.coupon.domain.Coupon;
import com.lucasvaladao.desafio.coupon.domain.CouponRepository;
import com.lucasvaladao.desafio.coupon.domain.Status;
import com.lucasvaladao.desafio.coupon.dto.CreateCouponRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCouponServiceTest {

    @Mock
    private CouponRepository repository;

    @InjectMocks
    private CreateCouponService service;

    @Test
    void shouldCreateAndSaveCoupon() {

        CreateCouponRequest request = new CreateCouponRequest();
        request.setCode("ABC-123");
        request.setDescription("desc");
        request.setDiscountValue(0.5);
        request.setExpirationDate(Instant.now().plusSeconds(3600));
        request.setPublished(false);

        when(repository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        Coupon result = service.execute(request);

        assertEquals("ABC123", result.getCode());
        verify(repository).save(any());
    }
}

