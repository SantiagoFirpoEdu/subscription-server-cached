package org.grupofort.domain.data_access.exceptions;

public class MismatchingPaidAmountException extends Exception
{
	public MismatchingPaidAmountException(double paidAmount, double totalCost)
	{
		super("Mismatching paid amount: %s, total cost: %s".formatted(paidAmount, totalCost));
	}
}
