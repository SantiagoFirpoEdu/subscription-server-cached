package org.grupofort.adapters.jpa.entities;

import jakarta.persistence.*;
import org.grupofort.domain.entities.User;
import org.grupofort.adapters.jpa.ConvertibleToDomainEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class UserJpaEntity implements ConvertibleToDomainEntity<User>
{
	@NonNull
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

	public static @NonNull UserJpaEntity fromDomainEntity(@NonNull User domainEntity)
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
}
