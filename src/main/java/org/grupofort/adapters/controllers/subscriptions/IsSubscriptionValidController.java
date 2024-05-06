package org.grupofort.adapters.controllers.subscriptions;

import org.grupofort.application.use_cases.subscriptions.query_subscription.QuerySubscription;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.domain.entities.ESubscriptionStatus;
import org.grupofort.domain.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/assinvalida")
public class IsSubscriptionValidController
{
	@Autowired
	public IsSubscriptionValidController(QuerySubscription querySubscription)
	{
		this.querySubscription = querySubscription;
	}

	@GetMapping("/{subscriptionId}")
	public boolean isSubscriptionValid(@PathVariable long subscriptionId) throws SubscriptionNotFoundException
	{
		Optional<Subscription> foundSubscription = querySubscription.findById(subscriptionId);

		if (foundSubscription.isEmpty())
		{
			throw new SubscriptionNotFoundException(subscriptionId);
		}

		Subscription subscription = foundSubscription.get();

		return subscription.status() == ESubscriptionStatus.ACTIVE;
	}

	private final QuerySubscription querySubscription;
}
