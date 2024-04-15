package org.grupofort.subscription_server.persistence_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PaymentJpaEntity
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
}
