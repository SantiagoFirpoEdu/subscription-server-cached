package org.grupofort.subscription_status_cache;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "subscription-status-service")
public interface SubscriptionStatusProxy
{
    @GetMapping("/subscription-status/{subscriptionId}")
    boolean getSubscriptionStatus(long subscriptionId);
}
