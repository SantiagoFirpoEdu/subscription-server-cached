package org.grupofort.adapters.controllers.payments;

import org.grupofort.domain.data_access.exceptions.MismatchingPaidAmountException;
import org.grupofort.domain.data_access.exceptions.InvalidPaidAmountException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.application.use_cases.execute_payment.RegisterPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class PaymentController
{
	@Autowired
    public PaymentController(RegisterPayment registerPayment)
    {
        this.registerPayment = registerPayment;
    }

    @PostMapping(path = "/registrarpagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse registerPayment(@RequestBody @NonNull RegisterPaymentRequest registerPaymentRequest) throws SubscriptionNotFoundException
    {
	    try
	    {
		    registerPayment.registerPayment(LocalDate.of(registerPaymentRequest.ano(), registerPaymentRequest.mes(), registerPaymentRequest.dia()), registerPaymentRequest.codass(), BigDecimal.valueOf(registerPaymentRequest.valorPago()));
			return new PaymentResponse(EPaymentStatus.OK_PAYMENT,0);
	    }
	    catch (InvalidPaidAmountException e)
	    {
            return new PaymentResponse(EPaymentStatus.INCORRECT_AMOUNT, 0);
        }
        catch (MismatchingPaidAmountException e)
        {
            return new PaymentResponse(EPaymentStatus.INCORRECT_AMOUNT, registerPaymentRequest.valorPago());
        }
    }

    private final RegisterPayment registerPayment;
}
