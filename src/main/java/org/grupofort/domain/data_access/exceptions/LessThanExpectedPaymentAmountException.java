package org.grupofort.domain.data_access.exceptions;

import java.math.BigDecimal;

public class LessThanExpectedPaymentAmountException extends Exception
{
	public LessThanExpectedPaymentAmountException(BigDecimal returnedValue, BigDecimal monthlyCost)
	{
		super("Invalid payment amount: %s. The payment amount must be greater than the monthly cost: %s".formatted(returnedValue, monthlyCost));
	}
}
