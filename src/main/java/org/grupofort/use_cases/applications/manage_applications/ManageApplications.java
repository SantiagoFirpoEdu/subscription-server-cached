package org.grupofort.use_cases.applications.manage_applications;

import org.grupofort.use_cases.applications.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageApplications
{
	@Autowired
	public ManageApplications(QueryApplicationsDataAccess applicationJpaRepository)
	{
		this.applicationJpaRepository = applicationJpaRepository;
	}

	private final QueryApplicationsDataAccess applicationJpaRepository;
}
