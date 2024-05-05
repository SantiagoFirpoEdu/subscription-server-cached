package org.grupofort.adapters.controllers.subscriptions;

import org.grupofort.application.use_cases.subscriptions.query_subscription.QuerySubscription;
import org.grupofort.domain.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "servcad/asscli")
public class SubscriptionsCustomersController
{
	@Autowired
	public SubscriptionsCustomersController(QuerySubscription querySubscriptions)
	{
		this.querySubscriptions = querySubscriptions;
	}

	@GetMapping("/{customerId}")
	List<Subscription> getSubscriptionsForCustomer(@PathVariable long customerId)
	{
		return querySubscriptions.getSubscriptionsForCustomer(customerId);
	}

	private final QuerySubscription querySubscriptions;
}
