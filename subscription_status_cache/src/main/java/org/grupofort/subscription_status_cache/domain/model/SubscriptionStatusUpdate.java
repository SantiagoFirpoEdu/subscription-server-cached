package org.grupofort.subscription_status_cache.domain.model;

import java.time.LocalDate;

public record SubscriptionStatusUpdate(long subscriptionId, LocalDate newEndDate)
{
}
