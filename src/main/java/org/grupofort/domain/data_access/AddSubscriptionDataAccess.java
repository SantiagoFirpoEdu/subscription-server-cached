package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;

public interface AddSubscriptionDataAccess
{
    Subscription addSubscription(long customerId, long applicationId) throws CustomerNotFoundException, ApplicationNotFoundException;
}
