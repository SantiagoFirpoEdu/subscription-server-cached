package org.grupofort.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;

public interface AddSubscriptionDataAccess
{
    boolean addSubscription(long customerId, long applicationId) throws CustomerNotFoundException, ApplicationNotFoundException;
}
