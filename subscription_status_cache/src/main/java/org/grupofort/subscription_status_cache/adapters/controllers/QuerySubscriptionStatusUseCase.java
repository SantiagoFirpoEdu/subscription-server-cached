package org.grupofort.subscription_status_cache.adapters.controllers;

import org.grupofort.subscription_status_cache.domain.data_access.SubscriptionStatusDataAccess;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QuerySubscriptionStatusUseCase
{
    public QuerySubscriptionStatusUseCase(SubscriptionStatusDataAccess subscriptionStatusDataAccess)
    {
        this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
    }

    public boolean getSubscriptionStatus(long subscriptionId)
    {
        return subscriptionStatusDataAccess.getSubscriptionEndDate(subscriptionId).isAfter(LocalDate.now());
    }

    private final SubscriptionStatusDataAccess subscriptionStatusDataAccess;
}
