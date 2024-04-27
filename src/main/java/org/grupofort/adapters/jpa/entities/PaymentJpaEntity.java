package org.grupofort.adapters.jpa.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.grupofort.domain.entities.Payment;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "payments")
public class PaymentJpaEntity implements ConvertibleToDomainEntity<Payment, PaymentJpaEntity>
{
	@Nonnull
	@Override
	public Payment toDomainEntity()
	{
		return new Payment
		(
			id,
			subscription.toDomainEntity(),
			paidAmount,
			paymentDate,
			Optional.ofNullable(promotionCode)
		);
	}

	@Override
	public PaymentJpaEntity fromDomainEntity(Payment domainEntity)
	{
		return new PaymentJpaEntity(domainEntity.id(), subscription.fromDomainEntity(domainEntity.subscription()), domainEntity.paidAmount(), domainEntity.paymentDate(), domainEntity.promotionCode().orElse("none"));
	}

	public Long getId()
	{
		return id;
	}

	private void setId(Long id)
	{
		this.id = id;
	}

	public PaymentJpaEntity(SubscriptionJpaEntity subscription, BigDecimal paidAmount, LocalDate paymentDate, String promotionCode)
	{
		this.subscription = subscription;
		this.paidAmount = paidAmount;
		this.paymentDate = paymentDate;
		this.promotionCode = promotionCode;
	}

	protected PaymentJpaEntity(Long id, SubscriptionJpaEntity subscription, BigDecimal paidAmount, LocalDate paymentDate, String promotionCode)
	{
		this
		(
			subscription,
			paidAmount,
			paymentDate,
			promotionCode
		);
		this.id = id;
	}

	protected PaymentJpaEntity() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(optional = false)
	private SubscriptionJpaEntity subscription;

	@Column(nullable = false)
	private BigDecimal paidAmount;

	@Column(nullable = false)
	private LocalDate paymentDate;

	@Column(nullable = true)
	private String promotionCode;
}
