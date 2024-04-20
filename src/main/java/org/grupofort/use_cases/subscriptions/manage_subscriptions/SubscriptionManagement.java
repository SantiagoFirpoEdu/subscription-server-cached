package org.grupofort.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;
import org.grupofort.use_cases.subscriptions.query_subscription.QuerySubscriptionsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubscriptionManagement
{
	@Autowired
	public SubscriptionManagement(AddSubscriptionDataAccess subscriptionDataAccess)
	{
		this.subscriptionDataAccess = subscriptionDataAccess;
	}

	public Subscription addSubscription(long customerId, long applicationId) throws ApplicationNotFoundException, CustomerNotFoundException
	{
		return subscriptionDataAccess.addSubscription(customerId, applicationId);
	}

	private final AddSubscriptionDataAccess subscriptionDataAccess;
}
