package org.grupofort.subscription_status_cache.adapters.kafka;

import org.grupofort.subscription_status_cache.domain.SubscriptionStatusDataAccess;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionStatusUpdateConsumer
{
	public SubscriptionStatusUpdateConsumer(SubscriptionStatusDataAccess subscriptionStatusDataAccess)
	{
		this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
	}

	@KafkaListener(topics = "subscription-status-update")
	public void listenToSubscriptionStatusUpdates(Boolean status)
	{
		subscriptionStatusDataAccess.updateSubscriptionStatus(1L, status);
	}

	private final SubscriptionStatusDataAccess subscriptionStatusDataAccess;
}
