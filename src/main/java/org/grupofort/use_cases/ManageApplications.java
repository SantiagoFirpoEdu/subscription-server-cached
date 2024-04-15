package org.grupofort.use_cases;

import org.grupofort.subscription_server.persistence.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageApplications
{
	@Autowired
	public ManageApplications(ApplicationRepository applicationRepository)
	{
		this.applicationRepository = applicationRepository;
	}

	private final ApplicationRepository applicationRepository;
}
