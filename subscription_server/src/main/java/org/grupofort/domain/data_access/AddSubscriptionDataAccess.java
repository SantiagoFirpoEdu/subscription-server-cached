package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;

import java.time.LocalDate;

public interface AddSubscriptionDataAccess
{
    Subscription addSubscription(long customerId, long applicationId, LocalDate startDate, LocalDate endDate) throws CustomerNotFoundException, ApplicationNotFoundException;
}
