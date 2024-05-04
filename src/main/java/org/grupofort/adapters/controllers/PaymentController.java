package org.grupofort.adapters.controllers;

import org.grupofort.domain.data_access.exceptions.MismatchingPaidAmountException;
import org.grupofort.domain.data_access.exceptions.InvalidPaidAmountException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.application.use_cases.execute_payment.RegisterPayment;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	    try
	    {
		    registerPayment.registerPayment(LocalDate.of(registerPaymentRequest.ano(), registerPaymentRequest.mes(), registerPaymentRequest.dia()), registerPaymentRequest.codass(), BigDecimal.valueOf(registerPaymentRequest.valorPago()));
	    }
	    catch (InvalidPaidAmountException | MismatchingPaidAmountException e)
	    {
            //TODO (Lucas): Implementar tratamento de erro e retorno
	    }
    }

    private final RegisterPayment registerPayment;
}
