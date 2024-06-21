package org.grupofort.subscription_status_cache.adapters.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class SubscriptionStatusUpdateConsumer
{
	@KafkaListener(topics = "subscription-status-update", groupId = "subscription-status-cache")
	public void listenToSubscriptionStatusUpdates(String message)
	{
		System.out.println("Received message: " + message);
	}
}
