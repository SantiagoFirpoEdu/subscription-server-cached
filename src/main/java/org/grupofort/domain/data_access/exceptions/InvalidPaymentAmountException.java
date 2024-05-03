package org.grupofort.domain.data_access.exceptions;

import java.math.BigDecimal;

public class InvalidPaymentAmountException extends Exception
{
	public InvalidPaymentAmountException(BigDecimal value)
	{
		super("Invalid payment amount: %s".formatted(value));
	}
}
