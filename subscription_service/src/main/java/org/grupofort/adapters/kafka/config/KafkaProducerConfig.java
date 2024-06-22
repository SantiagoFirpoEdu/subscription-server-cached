package org.grupofort.adapters.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.BooleanSerializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

	public KafkaProducerConfig(KafkaAdminConfig kafkaAdminConfig)
	{
		this.kafkaAdminConfig = kafkaAdminConfig;
	}

	@Bean
	public ProducerFactory<Long, Boolean> producerFactory()
	{
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(
				ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				BooleanSerializer.class);
		configProps.put(
				ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				kafkaAdminConfig.getBootstrapAddress());
		configProps.put(
				ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				LongSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<Long, Boolean> kafkaTemplate()
	{
		return new KafkaTemplate<>(producerFactory());
	}

	private final KafkaAdminConfig kafkaAdminConfig;
}
