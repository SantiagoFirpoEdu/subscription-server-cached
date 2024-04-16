package org.grupofort.use_cases.execute_payment;

import org.grupofort.subscription_server.data_access.RegisterPaymentDataAccess;
import org.grupofort.subscription_server.persistence.jpa_repositories.PaymentJpaRepository;
import org.grupofort.subscription_server.persistence.repositories.PaymentRepository;
import org.grupofort.use_cases.manage_subscriptions.SubscriptionDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExecutePayment
{
	@Autowired
	public ExecutePayment(RegisterPaymentDataAccess registerPaymentDataAccess)
	{
        this.registerPaymentDataAccess = registerPaymentDataAccess;
	}

	private final RegisterPaymentDataAccess registerPaymentDataAccess;
}
