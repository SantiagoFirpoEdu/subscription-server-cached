package org.grupofort.subscription_status_cache.domain.data_access;

import org.grupofort.subscription_status_cache.adapters.SubscriptionProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;

@Component
public class SubscriptionStatusDataAccess
{
    public SubscriptionStatusDataAccess(SubscriptionProxy subscriptionProxy)
    {
        this.subscriptionProxy = subscriptionProxy;
    }

    public LocalDate getSubscriptionEndDate(long subscriptionId)
    {
        return subscriptionStatuses.computeIfAbsent(subscriptionId, subscriptionProxy::getSubscriptionStatus);
    }

	public void updateSubscriptionStatus(Long subscriptionId, LocalDate newEndDate)
	{
		subscriptionStatuses.put(subscriptionId, newEndDate);
	}

    private final SubscriptionProxy subscriptionProxy;
    private final HashMap<Long, LocalDate> subscriptionStatuses = new HashMap<>();
}
