package org.grupofort.domain.data_access.exceptions;

public class InvalidPaidAmountException extends Exception
{
	public InvalidPaidAmountException(double paidAmount)
	{
		super("Invalid paid amount: %s".formatted(paidAmount));
	}
}
