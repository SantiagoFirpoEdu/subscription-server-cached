package org.grupofort.domain.data_access.subscriptions;

import org.grupofort.domain.data_access.exceptions.InvalidSubscriptionStatusException;
import org.springframework.lang.NonNull;

public enum ESubscriptionStatusFilter
{
	ALL,
	ACTIVE, CANCELLED;

	public static @NonNull ESubscriptionStatusFilter convertFromLocalized(@NonNull String filterType) throws InvalidSubscriptionStatusException
	{
		return switch (filterType)
		{
			case "TODAS" -> ALL;
			case "ATIVAS" -> ACTIVE;
			case "CANCELADAS" -> CANCELLED;
			default -> throw new InvalidSubscriptionStatusException(filterType);
		};
	}
}
