package org.grupofort.subscription_server.controllers;

import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;
import org.grupofort.use_cases.execute_payment.RegisterPayment;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class PaymentController
{
    public PaymentController(RegisterPayment registerPayment)
    {

        this.registerPayment = registerPayment;
    }
    @PostMapping(path = "/registrarpagamento")
    public void registerPayment(@RequestBody @NonNull RegisterPaymentRequest registerPaymentRequest) throws SubscriptionNotFoundException
    {
        registerPayment.registerPayment(LocalDate.of(registerPaymentRequest.ano(), registerPaymentRequest.mes(), registerPaymentRequest.dia()), registerPaymentRequest.codass(), registerPaymentRequest.valorPago());
    }

    private final RegisterPayment registerPayment;
}
