package org.grupofort.subscription_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SubscriptionGatewayApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionGatewayApplication.class, args);
	}
}
