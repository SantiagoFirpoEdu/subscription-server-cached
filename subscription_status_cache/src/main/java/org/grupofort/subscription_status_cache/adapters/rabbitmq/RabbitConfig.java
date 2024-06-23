package org.grupofort.subscription_status_cache.adapters.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class RabbitConfig
{
	@Bean
	public Declarables fanoutBindings()
	{
		Queue uniqueQueue = new Queue(queueName);
		FanoutExchange fanoutExchange = new FanoutExchange("subscription-status-update-fanout");

		return new Declarables
		(
			uniqueQueue,
			fanoutExchange,
			BindingBuilder.bind(uniqueQueue).to(fanoutExchange)
		);
	}

	@Bean
	public MessageConverter converter()
	{
		return new Jackson2JsonMessageConverter();
	}

	@SuppressWarnings("unused")
	public String getQueueName()
	{
		return queueName;
	}

	private final String queueName = "subscription-status-update-%s".formatted(UUID.randomUUID());
}
