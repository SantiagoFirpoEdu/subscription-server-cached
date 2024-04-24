package org.grupofort.adapters.repositories;

import org.grupofort.adapters.jpa.jpa_repositories.UserJpaRepository;
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
