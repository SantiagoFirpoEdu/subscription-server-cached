package org.grupofort.application.use_cases.subscriptions.query_subscription;

public class InvalidSubscriptionStatusException extends Exception
{
	public InvalidSubscriptionStatusException(String invalidValue)
	{
		super("Unknown filter type: %s".formatted(invalidValue));
	}
}
