package org.grupofort.subscription_server.persistence_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class SubscriptionJpaEntity
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
}
