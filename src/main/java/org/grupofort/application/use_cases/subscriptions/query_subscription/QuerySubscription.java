package org.grupofort.application.use_cases.subscriptions.query_subscription;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.domain.data_access.QuerySubscriptionsDataAccess;
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

	private final QuerySubscriptionsDataAccess querySubscriptionsDataAccess;
}
