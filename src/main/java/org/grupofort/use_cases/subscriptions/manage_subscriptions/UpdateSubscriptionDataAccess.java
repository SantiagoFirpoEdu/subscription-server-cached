package org.grupofort.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface UpdateSubscriptionDataAccess
{
    Subscription updateSubscriptionEndDate(long subscriptionId, LocalDate newEndDate) throws SubscriptionNotFoundException;
}
