package org.grupofort.domain.entities.subscription;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.Customer;

import java.time.LocalDate;

public record Subscription
(
	long id,
	Application application,
	Customer customer,
	LocalDate startDate,
	LocalDate endDate,
	ESubscriptionStatus status
)
{
}
