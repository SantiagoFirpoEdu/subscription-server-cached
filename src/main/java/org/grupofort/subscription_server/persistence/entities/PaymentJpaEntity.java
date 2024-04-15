package org.grupofort.subscription_server.persistence.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.grupofort.domain.entities.Payment;
import org.grupofort.subscription_server.persistence.ConvertibleToDomainEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Entity
public class PaymentJpaEntity implements ConvertibleToDomainEntity<Payment>
{
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

	@OneToOne(optional = false)
	private SubscriptionJpaEntity subscription;

	@Column(nullable = false)
	private BigDecimal paidAmount;

	@Column(nullable = false)
	private Date paymentDate;

	@Column(nullable = true)
	private String promotionCode;

	@Nonnull
	@Override
	public Payment toDomainEntity()
	{
		return new Payment(
			id,
			subscription.toDomainEntity(),
			paidAmount,
			paymentDate,
			Optional.ofNullable(promotionCode)
		);
	}
}
