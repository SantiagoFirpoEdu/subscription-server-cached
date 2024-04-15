package org.grupofort.subscription_server.persistence.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.ConvertibleToDomainEntity;

import java.math.BigDecimal;

@Entity
public class ApplicationJpaEntity implements ConvertibleToDomainEntity<Application>
{
	@Nonnull
	@Override
	public Application toDomainEntity()
	{
		return new Application
				       (
						       id,
						       name,
						       monthlyCost
				       );
	}

	public Long getId()
	{
		return id;
	}

	private void setId(Long id)
	{
		this.id = id;
	}

	@Id
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal monthlyCost;
}
