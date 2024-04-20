package org.grupofort.subscription_server.controllers.subscriptions;

public record CreateSubscriptionRequest(long customerId, long applicationId)
{
}
