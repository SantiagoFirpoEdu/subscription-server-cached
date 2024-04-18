package org.grupofort.subscription_server.controllers;

import org.grupofort.use_cases.execute_payment.ExecutePayment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PaymentController
{
    public PaymentController(ExecutePayment executePayment)
    {

        this.executePayment = executePayment;
    }
    @PostMapping(path = "registrarpagamento")
    public void registerPayment(@RequestParam(name = "dia") int day,
                         @RequestParam(name = "mes") int month,
                         @RequestParam("ano") int year,
                         @RequestParam("codass") long subscriptionId,
                         @RequestParam("valorPago")BigDecimal paidAmount)
    {

    }

    private final ExecutePayment executePayment;
}
