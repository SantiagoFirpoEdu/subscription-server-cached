package org.grupofort.adapters.jpa;

import jakarta.annotation.Nonnull;

public interface ConvertibleToDomainEntity<DomainEntityType, DTOType>
{
	@Nonnull
	DomainEntityType toDomainEntity();
	DTOType fromDomainEntity(DomainEntityType domainEntity);
}
