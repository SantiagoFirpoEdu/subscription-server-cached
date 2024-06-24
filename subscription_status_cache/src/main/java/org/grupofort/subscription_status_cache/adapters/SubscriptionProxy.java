package org.grupofort.subscription_status_cache.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name = "subscription-service")
public interface SubscriptionProxy
{
    @GetMapping("/servcad/assinaturas/datatermino/{subscriptionId}")
    LocalDate getSubscriptionStatus(@PathVariable long subscriptionId);
}
