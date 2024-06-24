package org.grupofort.adapters.controllers.subscriptions;

import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;
import org.grupofort.application.use_cases.subscriptions.manage_subscriptions.SubscriptionManagement;
import org.grupofort.domain.data_access.subscriptions.ESubscriptionStatusFilter;
import org.grupofort.domain.data_access.exceptions.InvalidSubscriptionStatusException;
import org.grupofort.application.use_cases.subscriptions.query_subscription.QuerySubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "servcad/assinaturas")
public class SubscriptionController
{
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @NonNull Subscription createSubscription(@RequestBody @NonNull CreateSubscriptionRequest createSubscriptionRequest) throws ApplicationNotFoundException, CustomerNotFoundException
	{
		return subscriptionManagement.addSubscription(createSubscriptionRequest.codigoCliente(), createSubscriptionRequest.codigoAplicativo());
	}

	@GetMapping()
	public List<Subscription> getAllSubscriptions()
	{
		return querySubscriptions.findAll();
	}

	@GetMapping("/{filterType}")
	public List<Subscription> getAllSubscriptionsByFilter(@PathVariable @NonNull String filterType) throws InvalidSubscriptionStatusException
	{
		return querySubscriptions.findAllByFilter(ESubscriptionStatusFilter.convertFromLocalized(filterType));
	}

	@GetMapping("id/{subscriptionId}")
	public Subscription getSubscription(@PathVariable @NonNull long subscriptionId) throws SubscriptionNotFoundException
    {
		Optional<Subscription> found = querySubscriptions.findById(subscriptionId);
		if (found.isEmpty())
		{
			throw new SubscriptionNotFoundException(subscriptionId);
		}

		return found.get();
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
