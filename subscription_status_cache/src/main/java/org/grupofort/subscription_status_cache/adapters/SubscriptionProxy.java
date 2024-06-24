package org.grupofort.subscription_status_cache.adapters;

import org.grupofort.subscription_status_cache.domain.model.entities.subscription.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subscription-service")
public interface SubscriptionProxy
{
    @GetMapping("/servcad/assinaturas/id/{subscriptionId}")
    Subscription getSubscriptionStatus(@PathVariable long subscriptionId);
}
