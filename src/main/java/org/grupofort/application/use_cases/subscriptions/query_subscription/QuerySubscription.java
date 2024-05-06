package org.grupofort.application.use_cases.subscriptions.query_subscription;

import org.grupofort.domain.data_access.subscriptions.ESubscriptionStatusFilter;
import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.domain.data_access.subscriptions.QuerySubscriptionsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuerySubscription
{
	@Autowired
	public QuerySubscription(QuerySubscriptionsDataAccess querySubscriptionsDataAccess)
	{
		this.querySubscriptionsDataAccess = querySubscriptionsDataAccess;
	}

	public List<Subscription> findAll()
	{
		return querySubscriptionsDataAccess.findAll();
	}

	public Optional<Subscription> findById(long subscriptionId)
	{
		return querySubscriptionsDataAccess.findById(subscriptionId);
	}

	public List<Subscription> findAllByFilter(ESubscriptionStatusFilter subscriptionStatusFilter)
	{
		return querySubscriptionsDataAccess.querySubscriptions(subscriptionStatusFilter);
	}

	public List<Subscription> getSubscriptionsForCustomer(long customerId)
	{
		return querySubscriptionsDataAccess.getSubscriptionsForCustomer(customerId);
	}

	private final QuerySubscriptionsDataAccess querySubscriptionsDataAccess;
}
