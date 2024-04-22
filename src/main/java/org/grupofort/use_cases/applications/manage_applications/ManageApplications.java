package org.grupofort.use_cases.applications.manage_applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.jpa_repositories.InvalidCostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ManageApplications
{
	@Autowired
	public ManageApplications(ManageApplicationsDataAccess manageApplicationsDataAccess)
	{
		this.manageApplicationsDataAccess = manageApplicationsDataAccess;
	}

	public Application updateApplicationCost(long applicationId, BigDecimal newCost) throws InvalidCostException, ApplicationNotFoundException
	{
		return manageApplicationsDataAccess.updateApplicationCost(applicationId, newCost);
	}

	private final ManageApplicationsDataAccess manageApplicationsDataAccess;
}
