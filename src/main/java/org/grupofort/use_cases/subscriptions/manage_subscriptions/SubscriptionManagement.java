package org.grupofort.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionManagement
{
	@Autowired
	public SubscriptionManagement(AddSubscriptionDataAccess subscriptionDataAccess)
	{
		this.subscriptionDataAccess = subscriptionDataAccess;
	}

	public boolean addSubscription(long customerId, long applicationId) throws ApplicationNotFoundException, CustomerNotFoundException
	{
		return subscriptionDataAccess.addSubscription(customerId, applicationId);
	}

	private final AddSubscriptionDataAccess subscriptionDataAccess;
}
