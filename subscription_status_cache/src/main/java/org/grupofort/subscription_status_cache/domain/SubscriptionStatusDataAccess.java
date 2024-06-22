package org.grupofort.subscription_status_cache.domain;

import org.grupofort.subscription_status_cache.adapters.SubscriptionStatusProxy;
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

	public void updateSubscriptionStatus(Long subscriptionId, Boolean isActive)
	{
		subscriptionStatuses.put(subscriptionId, isActive);
	}

    private final SubscriptionStatusProxy subscriptionStatusProxy;
    private final HashMap<Long, Boolean> subscriptionStatuses = new HashMap<>();
}
