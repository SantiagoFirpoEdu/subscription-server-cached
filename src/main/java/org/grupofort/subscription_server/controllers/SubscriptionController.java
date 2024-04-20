package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;
import org.grupofort.use_cases.subscriptions.manage_subscriptions.SubscriptionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "servcad/assinaturas")
public class SubscriptionController
{
	@PostMapping()
	Subscription createSubscription(@RequestBody CreateSubscriptionRequest createSubscriptionRequest) throws ApplicationNotFoundException, CustomerNotFoundException
	{
		return subscriptionManagement.addSubscription(createSubscriptionRequest.customerId(), createSubscriptionRequest.applicationId());
	}

	@Autowired()
	public SubscriptionController(SubscriptionManagement subscriptionManagement)
	{
		this.subscriptionManagement = subscriptionManagement;
	}

	private final SubscriptionManagement subscriptionManagement;
}
