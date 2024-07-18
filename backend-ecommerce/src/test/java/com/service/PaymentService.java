package com.example.ecommercebackend.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentIntent createPaymentIntent(Long amount) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
            .setAmount(amount)
            .setCurrency("usd") // Changez la devise si nécessaire
            .build();

        return PaymentIntent.create(params);
    }
}
