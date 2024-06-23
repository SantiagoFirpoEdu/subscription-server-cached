package org.grupofort.subscription_status_cache.adapters.controllers;

import org.grupofort.subscription_status_cache.domain.data_access.SubscriptionStatusDataAccess;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionStatusController
{
    public SubscriptionStatusController(SubscriptionStatusDataAccess subscriptionStatusDataAccess)
    {
        this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
    }

    @GetMapping("/assinvalida/{subscriptionId}")
    public boolean getSubscriptionStatus(@PathVariable long subscriptionId)
    {
        return subscriptionStatusDataAccess.getSubscriptionStatus(subscriptionId);
    }

    private final SubscriptionStatusDataAccess subscriptionStatusDataAccess;
}
