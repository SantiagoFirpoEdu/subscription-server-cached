package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.data_access.exceptions.InvalidCostException;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface ManageApplicationsDataAccess
{
	@NonNull
	Application updateApplicationCost(long applicationId, BigDecimal newCost) throws InvalidCostException, ApplicationNotFoundException;
}
