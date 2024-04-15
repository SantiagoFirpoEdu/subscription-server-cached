package org.grupofort.domain.entities;

import java.util.Date;

public record Subscription
(
	long id,
	Application application,
	Customer customer,
	Date startDate,
	Date endDate
)
{
}
