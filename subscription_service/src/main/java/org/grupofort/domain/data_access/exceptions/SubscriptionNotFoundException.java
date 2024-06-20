package org.grupofort.domain.data_access.exceptions;

public class SubscriptionNotFoundException extends Exception
{
    public SubscriptionNotFoundException(long subscriptionId)
    {
        super("Subscription with id %d not found".formatted(subscriptionId));
    }
}
