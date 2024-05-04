package org.grupofort.application.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.domain.data_access.AddSubscriptionDataAccess;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;
import org.grupofort.domain.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SubscriptionManagement
{
	@Autowired
	public SubscriptionManagement(AddSubscriptionDataAccess subscriptionDataAccess)
	{
		this.subscriptionDataAccess = subscriptionDataAccess;
	}

	public Subscription addSubscription(long customerId, long applicationId) throws ApplicationNotFoundException, CustomerNotFoundException
	{
        LocalDate now = LocalDate.now();
        return subscriptionDataAccess.addSubscription(customerId, applicationId, now, now.plusDays(7));
	}

	private final AddSubscriptionDataAccess subscriptionDataAccess;
}
