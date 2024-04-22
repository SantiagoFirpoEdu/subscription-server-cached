package org.grupofort.use_cases.applications.manage_applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.jpa_repositories.InvalidCostException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface ManageApplicationsDataAccess
{
	@NonNull Application updateApplicationCost(long applicationId, BigDecimal newCost) throws InvalidCostException, ApplicationNotFoundException;
}
