package org.grupofort.use_cases.manage_subscriptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionManagement
{
	@Autowired
	public SubscriptionManagement(SubscriptionDataAccess subscriptionDataAccess)
	{
		this.subscriptionDataAccess = subscriptionDataAccess;
	}

	public boolean addSubscription(long customerId, long applicationId)
	{
		return subscriptionDataAccess.addSubscription(customerId, applicationId);
	}

	private final SubscriptionDataAccess subscriptionDataAccess;
}
