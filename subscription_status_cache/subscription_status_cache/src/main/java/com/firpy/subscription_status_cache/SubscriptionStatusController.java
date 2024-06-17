package com.firpy.subscription_status_cache;

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

    @GetMapping("/subscription-status/{subscriptionId}")
    public boolean getSubscriptionStatus(@PathVariable long subscriptionId)
    {
        return subscriptionStatusDataAccess.getSubscriptionStatus(subscriptionId);
    }

    private final SubscriptionStatusDataAccess subscriptionStatusDataAccess;
}
