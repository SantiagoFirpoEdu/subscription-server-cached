package org.grupofort.adapters.jpa.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.grupofort.domain.entities.Customer;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;

@Entity
@Table(name = "customers")
public class CustomerJpaEntity implements ConvertibleToDomainEntity<Customer, CustomerJpaEntity>
{
	@Override
	public @Nonnull Customer toDomainEntity()
	{
		return new Customer
				       (
						       id,
						       name,
						       email
				       );
	}

	@Override
	public CustomerJpaEntity fromDomainEntity(Customer domainEntity)
	{
		return new CustomerJpaEntity(domainEntity.id(), domainEntity.name(), domainEntity.email());
	}

	public Long getId()
	{
		return id;
	}

	protected CustomerJpaEntity()
	{
	}

	protected CustomerJpaEntity(Long id, String name, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
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
}
