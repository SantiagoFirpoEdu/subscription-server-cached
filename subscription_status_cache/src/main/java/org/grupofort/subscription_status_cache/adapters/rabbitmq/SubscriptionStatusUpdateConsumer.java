package org.grupofort.subscription_status_cache.adapters.rabbitmq;

import org.grupofort.subscription_status_cache.domain.data_access.SubscriptionStatusDataAccess;
import org.grupofort.subscription_status_cache.domain.model.SubscriptionStatusUpdate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.lang.NonNull;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionStatusUpdateConsumer
{
	public SubscriptionStatusUpdateConsumer(SubscriptionStatusDataAccess subscriptionStatusDataAccess)
	{
		this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
	}

	@RabbitListener(queues = "#{rabbitConfig.getQueueName()}")
	public void listenToSubscriptionStatusUpdates(@Payload @NonNull SubscriptionStatusUpdate subscriptionStatusUpdate)
	{
		subscriptionStatusDataAccess.updateSubscriptionStatus(subscriptionStatusUpdate.subscriptionId(), subscriptionStatusUpdate.status());
	}

	private final SubscriptionStatusDataAccess subscriptionStatusDataAccess;
}
