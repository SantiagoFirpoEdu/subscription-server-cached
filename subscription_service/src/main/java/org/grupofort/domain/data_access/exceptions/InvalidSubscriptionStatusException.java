package org.grupofort.domain.data_access.exceptions;

public class InvalidSubscriptionStatusException extends Exception
{
	public InvalidSubscriptionStatusException(String invalidValue)
	{
		super("Unknown filter type: %s".formatted(invalidValue));
	}
}
