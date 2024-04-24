package org.grupofort.application.use_cases.subscriptions.query_subscription;

public enum ESubscriptionStatusFilter
{
	ALL,
	ACTIVE, CANCELLED;

	public static ESubscriptionStatusFilter convertFromLocalized(String filterType) throws InvalidSubscriptionStatusException
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
