package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<?> createPaymentIntent(@RequestParam Long amount) {
        try {
            PaymentIntent paymentIntent = paymentService.createPaymentIntent(amount);
            return ResponseEntity.ok(paymentIntent);
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

