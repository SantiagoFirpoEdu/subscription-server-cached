package org.grupofort.subscription_status_cache;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableRabbit
public class SubscriptionStatusCacheApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SubscriptionStatusCacheApplication.class, args);
    }
}
