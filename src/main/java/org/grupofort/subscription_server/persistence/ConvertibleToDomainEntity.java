package org.grupofort.subscription_server.persistence;

import jakarta.annotation.Nonnull;

public interface ConvertibleToDomainEntity<DomainEntityType>
{
	@Nonnull
	DomainEntityType toDomainEntity();
}
