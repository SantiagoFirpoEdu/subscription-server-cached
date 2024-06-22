package org.grupofort.subscription_status_cache.adapters.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.BooleanDeserializer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	public KafkaConsumerConfig(KafkaAdminConfig kafkaAdminConfig)
	{
		this.kafkaAdminConfig = kafkaAdminConfig;
	}

	@Bean
	public ConsumerFactory<Long, Boolean> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(
				ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				kafkaAdminConfig.getBootstrapAddress());
		props.put(
				ConsumerConfig.GROUP_ID_CONFIG,
				"subscription-status-cache");
		props.put(
				ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
				"earliest");
		props.put(
				ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				LongDeserializer.class);
		props.put(
				ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				BooleanDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Long, Boolean>
	kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<Long, Boolean> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	private final KafkaAdminConfig kafkaAdminConfig;
}
