package org.grupofort.subscription_server.controllers;

public record CreateSubscriptionRequest(long customerId, long applicationId)
{
}
