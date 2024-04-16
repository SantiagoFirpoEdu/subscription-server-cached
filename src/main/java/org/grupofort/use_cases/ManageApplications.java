package org.grupofort.use_cases;

import org.grupofort.subscription_server.persistence.jpa_repositories.ApplicationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageApplications
{
	@Autowired
	public ManageApplications(ApplicationJpaRepository applicationJpaRepository)
	{
		this.applicationJpaRepository = applicationJpaRepository;
	}

	private final ApplicationJpaRepository applicationJpaRepository;
}
