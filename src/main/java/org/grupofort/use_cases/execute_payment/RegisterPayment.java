package org.grupofort.use_cases.execute_payment;

import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RegisterPayment
{
	@Autowired
	public RegisterPayment(RegisterPaymentDataAccess registerPaymentDataAccess)
	{
        this.registerPaymentDataAccess = registerPaymentDataAccess;
	}

	public void registerPayment(LocalDate date, long subscriptionId, BigDecimal paidAmount) throws SubscriptionNotFoundException
	{
		registerPaymentDataAccess.registerPayment(date, subscriptionId, paidAmount);
	}


	private final RegisterPaymentDataAccess registerPaymentDataAccess;
}
