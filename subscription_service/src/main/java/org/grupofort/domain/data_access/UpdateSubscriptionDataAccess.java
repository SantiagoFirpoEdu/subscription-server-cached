package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.subscription.ESubscriptionStatus;
import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface UpdateSubscriptionDataAccess
{
    Subscription updateSubscriptionEndDate(long subscriptionId, LocalDate newEndDate) throws SubscriptionNotFoundException;
    void notifySubscriptionStatusChanged(long subscriptionId, @NonNull ESubscriptionStatus newStatus);
}
