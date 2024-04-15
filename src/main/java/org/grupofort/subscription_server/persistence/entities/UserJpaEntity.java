package org.grupofort.subscription_server.persistence.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.grupofort.domain.entities.User;
import org.grupofort.subscription_server.persistence.ConvertibleToDomainEntity;

@Entity
public class UserJpaEntity implements ConvertibleToDomainEntity<User>
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
