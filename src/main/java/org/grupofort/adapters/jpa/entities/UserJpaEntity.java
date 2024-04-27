package org.grupofort.adapters.jpa.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.grupofort.domain.entities.User;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;

@Entity
@Table(name = "users")
public class UserJpaEntity implements ConvertibleToDomainEntity<User, UserJpaEntity>
{
	@Nonnull
	@Override
	public User toDomainEntity()
	{
		return new User
		(
			id,
			username,
			password
		);
	}

	@Override
	public UserJpaEntity fromDomainEntity(User domainEntity)
	{
		return new UserJpaEntity
		(
			domainEntity.id(),
			domainEntity.username(),
			domainEntity.password()
		);
	}

	protected UserJpaEntity() {}

	protected UserJpaEntity(Long id, String username, String password)
	{
		this.id = id;
		this.username = username;
		this.password = password;
	}

	private Long getId()
	{
		return id;
	}

	private void setId(Long id)
	{
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
}
