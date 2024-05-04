package org.grupofort.application.use_cases.applications.manage_applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.adapters.jpa.entities.ApplicationJpaEntity;
import org.grupofort.adapters.jpa.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.domain.data_access.ManageApplicationsDataAccess;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.InvalidCostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ManageApplications
{
	@Autowired
	public ManageApplications(ManageApplicationsDataAccess manageApplicationsDataAccess, ApplicationJpaRepository applicationJpaRepository)
	{
		this.manageApplicationsDataAccess = manageApplicationsDataAccess;
		this.applicationJpaRepository = applicationJpaRepository;
	}

	public Application updateApplicationCost(long applicationId, BigDecimal newCost) throws ApplicationNotFoundException
	{
		Optional<ApplicationJpaEntity> applicationOpt = applicationJpaRepository.findById(applicationId);
		if (applicationOpt.isEmpty())
		{
			throw new ApplicationNotFoundException("Application with ID " + applicationId + " not found.");
		}

		ApplicationJpaEntity application = applicationOpt.get();
		application.setMonthlyCost(newCost);

		return applicationJpaRepository.save(application).toDomainEntity();
	}

	private final ManageApplicationsDataAccess manageApplicationsDataAccess;
	private final ApplicationJpaRepository applicationJpaRepository;

}
