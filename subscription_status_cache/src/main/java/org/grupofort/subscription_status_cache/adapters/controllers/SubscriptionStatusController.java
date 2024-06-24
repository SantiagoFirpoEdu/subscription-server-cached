package org.grupofort.subscription_status_cache.adapters.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionStatusController
{
    public SubscriptionStatusController(QuerySubscriptionStatusUseCase querySubscriptionStatusUseCase)
    {
        this.querySubscriptionStatusUseCase = querySubscriptionStatusUseCase;
    }

    @GetMapping("/assinvalida/{subscriptionId}")
    public boolean getSubscriptionStatus(@PathVariable long subscriptionId)
    {
        return querySubscriptionStatusUseCase.getSubscriptionStatus(subscriptionId);
    }

    private final QuerySubscriptionStatusUseCase querySubscriptionStatusUseCase;
}
