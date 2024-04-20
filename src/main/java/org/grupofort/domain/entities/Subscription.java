package org.grupofort.domain.entities;

import java.time.LocalDate;

public record Subscription
(
	long id,
	Application application,
	Customer customer,
	LocalDate startDate,
	LocalDate endDate
)
{
}
