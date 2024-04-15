package org.grupofort.subscription_server.persistence.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.grupofort.domain.entities.Customer;
import org.grupofort.subscription_server.persistence.ConvertibleToDomainEntity;

@Entity
public class CustomerJpaEntity implements ConvertibleToDomainEntity<Customer>
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

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Override
	public @Nonnull Customer toDomainEntity()
	{
		return new Customer(
			id,
			name,
			email
		);
	}
}
