package org.grupofort.subscription_status_cache.adapters.kafka;

import org.grupofort.subscription_status_cache.domain.SubscriptionStatusDataAccess;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionStatusUpdateConsumer
{
	public SubscriptionStatusUpdateConsumer(SubscriptionStatusDataAccess subscriptionStatusDataAccess)
	{
		this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
	}

	@KafkaListener(topics = "subscription-status-update")
	public void listenToSubscriptionStatusUpdates(@Payload Boolean status,
	                                              @Header(KafkaHeaders.RECEIVED_KEY) Long subscriptionId)
	{
		subscriptionStatusDataAccess.updateSubscriptionStatus(subscriptionId, status);
	}

	private final SubscriptionStatusDataAccess subscriptionStatusDataAccess;
}
