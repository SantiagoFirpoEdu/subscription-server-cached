package com.firpy.subscription_status_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SubscriptionStatusCacheApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SubscriptionStatusCacheApplication.class, args);
    }
}
