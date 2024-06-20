package org.grupofort.subscription_status_cache;

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
        return subscriptionStatuses.computeIfAbsent(subscriptionId, subscriptionStatusProxy::getSubscriptionStatus);
    }

    private final SubscriptionStatusProxy subscriptionStatusProxy;
    private final HashMap<Long, Boolean> subscriptionStatuses = new HashMap<>();
}
