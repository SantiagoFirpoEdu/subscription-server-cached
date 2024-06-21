package org.grupofort.adapters.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig
{
	@Bean
	public KafkaAdmin kafkaAdmin()
	{
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new KafkaAdmin(configs);
	}

	public String getBootstrapAddress()
	{
		return bootstrapAddress;
	}

	@Value("${spring.kafka.bootstrap-servers:http://localhost:9090}")
	private String bootstrapAddress;
}
