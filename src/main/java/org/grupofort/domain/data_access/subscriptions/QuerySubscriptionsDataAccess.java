package org.grupofort.domain.data_access.subscriptions;

import org.grupofort.domain.entities.subscription.Subscription;

import java.util.List;
import java.util.Optional;

public interface QuerySubscriptionsDataAccess
{
	List<Subscription> querySubscriptions(ESubscriptionStatusFilter statusFilter);
	List<Subscription> getSubscriptionsForCustomer(long customerId);

	List<Subscription> findAll();

	Optional<Subscription> findById(long subscriptionId);
}
