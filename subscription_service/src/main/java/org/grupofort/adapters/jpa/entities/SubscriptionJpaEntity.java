package org.grupofort.adapters.jpa.entities;

import jakarta.persistence.*;
import org.grupofort.domain.entities.subscription.ESubscriptionStatus;
import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class SubscriptionJpaEntity implements ConvertibleToDomainEntity<Subscription>
{
	@NonNull
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

	public @NonNull ESubscriptionStatus getStatus()
	{
        return LocalDate.now().isAfter(endDate) ? ESubscriptionStatus.CANCELLED
												: ESubscriptionStatus.ACTIVE;
	}

	public static @NonNull SubscriptionJpaEntity fromDomainEntity(@NonNull Subscription domainEntity)
	{
		return new SubscriptionJpaEntity(
			domainEntity.id(),
			ApplicationJpaEntity.fromDomainEntity(domainEntity.application()),
			CustomerJpaEntity.fromDomainEntity(domainEntity.customer()),
			domainEntity.startDate(),
			domainEntity.endDate()
		);
	}

	public Long getId()
	{
		return id;
	}

	public ApplicationJpaEntity getApplication() {
        return application;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public void setEndDate(LocalDate endDate)
	{
		this.endDate = endDate;
	}

	@ManyToOne
	ApplicationJpaEntity application;

	@ManyToOne
	CustomerJpaEntity customer;

	@Column
	LocalDate startDate;

	@Column
	LocalDate endDate;
}
