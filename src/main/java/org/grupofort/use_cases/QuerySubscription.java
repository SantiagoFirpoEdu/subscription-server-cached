package org.grupofort.use_cases;

import org.grupofort.subscription_server.persistence.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuerySubscription
{
	@Autowired
	public QuerySubscription(SubscriptionRepository subscriptionRepository)
	{
		this.subscriptionRepository = subscriptionRepository;
	}

	private final SubscriptionRepository subscriptionRepository;
}
