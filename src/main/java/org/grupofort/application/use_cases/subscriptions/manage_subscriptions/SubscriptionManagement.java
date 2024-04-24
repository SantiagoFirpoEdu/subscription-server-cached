package org.grupofort.application.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.domain.data_access.AddSubscriptionDataAccess;
import org.grupofort.domain.data_access.UpdateSubscriptionDataAccess;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SubscriptionManagement
{
	@Autowired
	public SubscriptionManagement(AddSubscriptionDataAccess subscriptionDataAccess, UpdateSubscriptionDataAccess updateSubscriptionDataAccess)
	{
		this.subscriptionDataAccess = subscriptionDataAccess;
        this.updateSubscriptionDataAccess = updateSubscriptionDataAccess;
    }

	public Subscription addSubscription(long customerId, long applicationId) throws ApplicationNotFoundException, CustomerNotFoundException
	{
		return subscriptionDataAccess.addSubscription(customerId, applicationId);
	}

	public void updateSubscriptionEndDate(long subscriptionId, LocalDate newEndDate) throws SubscriptionNotFoundException
	{
		updateSubscriptionDataAccess.updateSubscriptionEndDate(subscriptionId, newEndDate);
	}

	private final AddSubscriptionDataAccess subscriptionDataAccess;
	private final UpdateSubscriptionDataAccess updateSubscriptionDataAccess;
}
