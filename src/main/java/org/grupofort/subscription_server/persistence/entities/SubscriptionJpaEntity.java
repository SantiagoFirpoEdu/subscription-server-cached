package org.grupofort.subscription_server.persistence.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.grupofort.domain.entities.ESubscriptionStatus;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.ConvertibleToDomainEntity;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class SubscriptionJpaEntity implements ConvertibleToDomainEntity<Subscription, SubscriptionJpaEntity>
{
	@Nonnull
	@Override
	public Subscription toDomainEntity()
	{
		return new Subscription
				       (
						       id,
						       application.toDomainEntity(),
						       customer.toDomainEntity(),
						       startDate,
						       endDate,
							   getStatus()
				       );
	}

	public ESubscriptionStatus getStatus()
	{
        return LocalDate.now().isAfter(endDate) ? ESubscriptionStatus.CANCELLED
												: ESubscriptionStatus.ACTIVE;
	}

	@Override
	public SubscriptionJpaEntity fromDomainEntity(Subscription domainEntity)
	{
		return new SubscriptionJpaEntity(
			domainEntity.id(),
			application.fromDomainEntity(domainEntity.application()),
			customer.fromDomainEntity(domainEntity.customer()),
			domainEntity.startDate(),
			domainEntity.endDate()
		);
	}

	public Long getId()
	{
		return id;
	}

	public SubscriptionJpaEntity(ApplicationJpaEntity application, CustomerJpaEntity customer, LocalDate startDate, LocalDate endDate)
	{
		this.application = application;
		this.customer = customer;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	protected SubscriptionJpaEntity(Long id, ApplicationJpaEntity application, CustomerJpaEntity customer, LocalDate startDate, LocalDate endDate)
	{
		this
		(
			application,
			customer,
			startDate,
			endDate
		);
		this.id = id;
	}

	protected SubscriptionJpaEntity()
	{
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
	LocalDate startDate;

	@Column
	LocalDate endDate;
}
