package org.grupofort.use_cases.subscriptions.manage_subscriptions;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface UpdateSubscriptionDataAccess
{
    boolean updateSubscriptionEndDate(long subscriptionId, LocalDate newEndDate);
}
