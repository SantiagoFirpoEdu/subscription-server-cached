package org.grupofort.adapters.jpa.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.grupofort.domain.entities.Application;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "applications")
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

	public static ApplicationJpaEntity fromDomainEntity(Application domainEntity)
	{
		return new ApplicationJpaEntity(domainEntity.id(), domainEntity.name(), domainEntity.monthlyCost());
	}

	public Long getId()
	{
		return id;
	}

	public BigDecimal getMonthlyCost()
	{
		return monthlyCost;
	}

	public void setMonthlyCost(BigDecimal newCost)
	{
		monthlyCost = newCost;
	}

	protected ApplicationJpaEntity()
	{
	}

	protected ApplicationJpaEntity(Long id, String name, BigDecimal monthlyCost)
	{
		this.id = id;
		this.name = name;
		this.monthlyCost = monthlyCost;
	}

	private void setId(Long id)
	{
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal monthlyCost;
}
