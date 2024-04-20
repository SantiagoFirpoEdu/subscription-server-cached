package org.grupofort.subscription_server.controllers;

import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;
import org.grupofort.use_cases.execute_payment.RegisterPayment;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping(path = "registrarpagamento")
    public void registerPayment(@RequestParam(name = "dia") int day,
                         @RequestParam(name = "mes") int month,
                         @RequestParam("ano") int year,
                         @RequestParam("codass") long subscriptionId,
                         @RequestParam("valorPago")BigDecimal paidAmount) throws SubscriptionNotFoundException
    {
        registerPayment.registerPayment(LocalDate.of(year, month, day), subscriptionId, paidAmount);
    }

    private final RegisterPayment registerPayment;
}
