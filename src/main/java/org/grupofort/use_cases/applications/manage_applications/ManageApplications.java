package org.grupofort.use_cases.applications.manage_applications;

import org.grupofort.domain.entities.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageApplications
{
	@Autowired
	public ManageApplications(ManageApplicationsDataAccess manageApplicationsDataAccess)
	{
		this.manageApplicationsDataAccess = manageApplicationsDataAccess;
	}

	public Application updateApplicationCost(long applicationId, double newCost)
	{
		return manageApplicationsDataAccess.updateApplicationCost(applicationId, newCost);
	}

	private final ManageApplicationsDataAccess manageApplicationsDataAccess;
}
