package org.grupofort.domain.entities.subscription;

import java.time.LocalDate;

public record SubscriptionStatusUpdate(long subscriptionId, LocalDate newEndDate)
{
}
