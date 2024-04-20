package org.grupofort.use_cases.applications.manage_applications;

import org.grupofort.domain.entities.Application;
import org.springframework.stereotype.Component;

@Component
public interface ManageApplicationsDataAccess
{
	Application updateApplicationCost(long applicationId, double newCost);
}
