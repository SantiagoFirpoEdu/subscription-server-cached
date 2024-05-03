package org.grupofort.adapters.jpa;

import jakarta.annotation.Nonnull;

public interface ConvertibleToDomainEntity<DomainEntityType>
{
	@Nonnull
	DomainEntityType toDomainEntity();
}
