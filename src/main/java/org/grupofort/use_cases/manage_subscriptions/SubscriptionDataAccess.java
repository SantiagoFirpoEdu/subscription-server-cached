package org.grupofort.use_cases.manage_subscriptions;

import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;

public interface SubscriptionDataAccess
{
    boolean addSubscription(long customerId, long applicationId) throws CustomerNotFoundException, ApplicationNotFoundException;
}
