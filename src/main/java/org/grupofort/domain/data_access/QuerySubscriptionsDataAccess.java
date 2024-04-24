package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.application.use_cases.subscriptions.query_subscription.ESubscriptionStatusFilter;

import java.util.List;

public interface QuerySubscriptionsDataAccess
{
	List<Subscription> querySubscriptions(ESubscriptionStatusFilter statusFilter);
	List<Subscription> getSubscriptionsForCustomer(long customerId);
	boolean isSubscriptionActive(long subscriptionId) throws SubscriptionNotFoundException;

	List<Subscription> findAll();
}
