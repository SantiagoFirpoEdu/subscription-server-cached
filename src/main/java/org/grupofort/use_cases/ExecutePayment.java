package org.grupofort.use_cases;

import org.grupofort.subscription_server.persistence.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExecutePayment
{
	@Autowired
	public ExecutePayment(PaymentRepository paymentRepository)
	{
		this.paymentRepository = paymentRepository;
	}

	private final PaymentRepository paymentRepository;
}
