package org.grupofort.adapters.controllers.payments;

import org.grupofort.application.use_cases.subscriptions.query_subscription.QuerySubscription;
import org.grupofort.domain.data_access.exceptions.MismatchingPaidAmountException;
import org.grupofort.domain.data_access.exceptions.InvalidPaidAmountException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.application.use_cases.execute_payment.RegisterPayment;
import org.grupofort.domain.entities.subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@RestController
public class PaymentController
{
	@Autowired
    public PaymentController(RegisterPayment registerPayment, QuerySubscription querySubscription)
    {
        this.registerPayment = registerPayment;
	    this.querySubscription = querySubscription;
    }

    @PostMapping(path = "/registrarpagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public @NonNull PaymentResponse registerPayment(@RequestBody @NonNull RegisterPaymentRequest registerPaymentRequest) throws SubscriptionNotFoundException
    {
	    try
	    {
		    LocalDate newEndDate = registerPayment.registerPayment(LocalDate.of(registerPaymentRequest.ano(), registerPaymentRequest.mes(), registerPaymentRequest.dia()), registerPaymentRequest.codass(), BigDecimal.valueOf(registerPaymentRequest.valorPago()));
			return new PaymentResponse(EPaymentStatus.OK_PAYMENT, newEndDate,0.0);
	    }
	    catch (InvalidPaidAmountException e)
	    {
		    Optional<Subscription> subscription = querySubscription.findById(registerPaymentRequest.codass());

			if (subscription.isEmpty())
		    {
				throw new SubscriptionNotFoundException(registerPaymentRequest.codass());
		    }

		    return new PaymentResponse(EPaymentStatus.INCORRECT_AMOUNT, subscription.get().endDate(), 0.0);
        }
        catch (MismatchingPaidAmountException e)
        {
	        Optional<Subscription> subscription = querySubscription.findById(registerPaymentRequest.codass());

	        if (subscription.isEmpty())
	        {
		        throw new SubscriptionNotFoundException(registerPaymentRequest.codass());
	        }
            return new PaymentResponse(EPaymentStatus.INCORRECT_AMOUNT, subscription.get().endDate(), registerPaymentRequest.valorPago());
        }
    }

    private final RegisterPayment registerPayment;
	private final QuerySubscription querySubscription;
}
