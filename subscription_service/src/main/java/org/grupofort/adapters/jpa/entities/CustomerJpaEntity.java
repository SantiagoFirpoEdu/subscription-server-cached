package org.grupofort.adapters.jpa.entities;

import jakarta.persistence.*;
import org.grupofort.domain.entities.Customer;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "customers")
public class CustomerJpaEntity implements ConvertibleToDomainEntity<Customer>
{
	@Override
	public @NonNull Customer toDomainEntity()
	{
		return new Customer
				       (
						       id,
						       name,
						       email
				       );
	}

	public static @NonNull CustomerJpaEntity fromDomainEntity(@NonNull Customer domainEntity)
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;
}
