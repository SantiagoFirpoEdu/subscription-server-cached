package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;
import org.grupofort.use_cases.subscriptions.manage_subscriptions.SubscriptionManagement;
import org.grupofort.use_cases.subscriptions.query_subscription.ESubscriptionStatusFilter;
import org.grupofort.use_cases.subscriptions.query_subscription.InvalidSubscriptionStatusException;
import org.grupofort.use_cases.subscriptions.query_subscription.QuerySubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "servcad/assinaturas")
public class SubscriptionController
{
	@PostMapping()
	public Subscription createSubscription(@RequestBody CreateSubscriptionRequest createSubscriptionRequest) throws ApplicationNotFoundException, CustomerNotFoundException
	{
		return subscriptionManagement.addSubscription(createSubscriptionRequest.customerId(), createSubscriptionRequest.applicationId());
	}

	@GetMapping
	public List<Subscription> getAllSubscriptions()
	{
		return querySubscriptions.findAll();
	}

	@GetMapping("/{filterType}")
	public List<Subscription> getAllSubscriptionsByFilter(@PathVariable String filterType) throws InvalidSubscriptionStatusException
	{
		return querySubscriptions.findAllByFilter(ESubscriptionStatusFilter.convertFromLocalized(filterType));
	}

	@Autowired()
	public SubscriptionController(SubscriptionManagement subscriptionManagement, QuerySubscription querySubscriptions)
	{
		this.subscriptionManagement = subscriptionManagement;
		this.querySubscriptions = querySubscriptions;
	}

	private final SubscriptionManagement subscriptionManagement;
	private final QuerySubscription querySubscriptions;
}
