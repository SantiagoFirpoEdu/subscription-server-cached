package org.grupofort.subscription_server.persistence.repositories;

import org.grupofort.subscription_server.persistence.jpa_repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository
{
	@Autowired
	public UserRepository(UserJpaRepository userJpaRepository)
	{
		this.userJpaRepository = userJpaRepository;
	}

	private final UserJpaRepository userJpaRepository;

}
