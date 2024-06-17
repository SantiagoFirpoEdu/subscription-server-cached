package com.firpy.subscription_status_cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SubscriptionStatusDataAccess
{
    public SubscriptionStatusDataAccess(SubscriptionStatusProxy subscriptionStatusProxy)
    {
        this.subscriptionStatusProxy = subscriptionStatusProxy;
    }

    public boolean getSubscriptionStatus(long subscriptionId)
    {
        if (!subscriptionStatuses.containsKey(subscriptionId))
        {
            subscriptionStatuses.put(subscriptionId, subscriptionStatusProxy.getSubscriptionStatus(subscriptionId));
        }

        return subscriptionStatuses.get(subscriptionId);
    }

    private final SubscriptionStatusProxy subscriptionStatusProxy;
    private final HashMap<Long, Boolean> subscriptionStatuses = new HashMap<>();
}
