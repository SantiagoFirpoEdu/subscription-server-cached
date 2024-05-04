package org.grupofort.application.use_cases.execute_payment;

import org.grupofort.domain.data_access.RegisterPaymentDataAccess;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
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
