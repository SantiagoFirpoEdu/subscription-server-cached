package org.grupofort.use_cases.applications.manage_applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.jpa_repositories.InvalidCostException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public interface ManageApplicationsDataAccess
{
	@NonNull Application updateApplicationCost(long applicationId, double newCost) throws InvalidCostException;
}
