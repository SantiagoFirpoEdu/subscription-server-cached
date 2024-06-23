package org.grupofort.adapters.rabbitmq;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig
{
	@Bean
	public Declarables fanoutBindings()
	{
		FanoutExchange fanoutExchange = new FanoutExchange("subscription-status-update-fanout");

		return new Declarables
		(
			fanoutExchange
		);
	}

	@Bean
	public MessageConverter converter()
	{
		return new Jackson2JsonMessageConverter();
	}
}
