package org.grupofort.subscription_server.jpa.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.grupofort.domain.entities.User;
import org.grupofort.subscription_server.jpa.ConvertibleToDomainEntity;

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
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
}
