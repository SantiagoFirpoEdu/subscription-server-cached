package org.grupofort.subscription_server.persistence;

import jakarta.annotation.Nonnull;

public interface ConvertibleToDomainEntity<DomainEntityType, DTOType>
{
	@Nonnull
	DomainEntityType toDomainEntity();
	DTOType fromDomainEntity(DomainEntityType domainEntity);
}
