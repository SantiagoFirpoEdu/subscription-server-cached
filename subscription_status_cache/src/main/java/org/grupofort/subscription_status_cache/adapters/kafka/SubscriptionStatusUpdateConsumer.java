package org.grupofort.subscription_status_cache.adapters.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionStatusUpdateConsumer
{
	@KafkaListener(topics = "subscription-status-update")
	public void listenToSubscriptionStatusUpdates(String message)
	{
		System.out.println("Received message: " + message);
	}
}
