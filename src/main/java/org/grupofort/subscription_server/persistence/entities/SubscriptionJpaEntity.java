package org.grupofort.subscription_server.persistence.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.ConvertibleToDomainEntity;

import java.util.Date;

@Entity
public class SubscriptionJpaEntity implements ConvertibleToDomainEntity<Subscription>
{
	public Long getId()
	{
		return id;
	}

	@Id
	private Long id;

	private void setId(Long id)
	{
		this.id = id;
	}

	@OneToOne
	ApplicationJpaEntity application;

	@OneToOne
	CustomerJpaEntity customer;

	@Column
	Date startDate;

	@Column
	Date endDate;

	@Nonnull
	@Override
	public Subscription toDomainEntity()
	{
		return new Subscription(
			id,
			application.toDomainEntity(),
			customer.toDomainEntity(),
			startDate,
			endDate
		);
	}
}
