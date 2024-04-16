package org.grupofort.use_cases;

import org.grupofort.subscription_server.persistence.jpa_repositories.SubscriptionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuerySubscription
{
	@Autowired
	public QuerySubscription(SubscriptionJpaRepository subscriptionJpaRepository)
	{
		this.subscriptionJpaRepository = subscriptionJpaRepository;
	}

	private final SubscriptionJpaRepository subscriptionJpaRepository;
}
