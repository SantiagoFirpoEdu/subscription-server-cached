package org.grupofort.subscription_status_cache.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subscription-service")
public interface SubscriptionStatusProxy
{
    @GetMapping("/assinvalida/{subscriptionId}")
    boolean getSubscriptionStatus(@PathVariable long subscriptionId);
}
