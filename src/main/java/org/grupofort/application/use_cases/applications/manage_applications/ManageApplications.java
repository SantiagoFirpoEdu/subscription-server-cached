package org.grupofort.application.use_cases.applications.manage_applications;

import org.grupofort.domain.data_access.exceptions.InvalidCostException;
import org.grupofort.domain.entities.Application;
import org.grupofort.domain.data_access.ManageApplicationsDataAccess;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
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

	public Application updateApplicationCost(long applicationId, BigDecimal newCost) throws ApplicationNotFoundException, InvalidCostException
	{
		return manageApplicationsDataAccess.updateApplicationCost(applicationId, newCost);
	}

	private final ManageApplicationsDataAccess manageApplicationsDataAccess;

}
