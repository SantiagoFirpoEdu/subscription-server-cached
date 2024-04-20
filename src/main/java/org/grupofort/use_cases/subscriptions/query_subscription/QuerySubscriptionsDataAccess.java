package org.grupofort.use_cases.subscriptions.query_subscription;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;

import java.util.List;

public interface QuerySubscriptionsDataAccess
{
	List<Subscription> querySubscriptions(ESubscriptionStatusFilter statusFilter);
	boolean isSubscriptionActive(long subscriptionId) throws SubscriptionNotFoundException;
}
