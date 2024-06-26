package org.grupofort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubscriptionService
{
	public static void main(String[] args)
	{
		SpringApplication.run(SubscriptionService.class, args);
	}
}
