package org.grupofort.adapters.jpa.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.grupofort.domain.entities.ESubscriptionStatus;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class SubscriptionJpaEntity implements ConvertibleToDomainEntity<Subscription>
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

	public static SubscriptionJpaEntity fromDomainEntity(Subscription domainEntity)
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

    public void setApplication(ApplicationJpaEntity application) {
        this.application = application;
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

	public LocalDate getEndDate() {
        return endDate;
    }

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
