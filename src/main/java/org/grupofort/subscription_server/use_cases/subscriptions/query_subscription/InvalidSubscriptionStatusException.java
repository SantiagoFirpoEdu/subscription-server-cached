package org.grupofort.subscription_server.use_cases.subscriptions.query_subscription;

public class InvalidSubscriptionStatusException extends Exception
{
	public InvalidSubscriptionStatusException(String invalidValue)
	{
		super("Unknown filter type: %s".formatted(invalidValue));
	}
}
