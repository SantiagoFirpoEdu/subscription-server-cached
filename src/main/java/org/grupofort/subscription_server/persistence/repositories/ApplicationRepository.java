package org.grupofort.subscription_server.persistence.repositories;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.entities.ApplicationJpaEntity;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.subscription_server.persistence.jpa_repositories.InvalidCostException;
import org.grupofort.use_cases.applications.manage_applications.ManageApplicationsDataAccess;
import org.grupofort.use_cases.applications.query_applications.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ApplicationRepository implements ManageApplicationsDataAccess, QueryApplicationsDataAccess
{
	@Autowired
	public ApplicationRepository(ApplicationJpaRepository applicationJpaRepository)
	{
		this.applicationJpaRepository = applicationJpaRepository;
	}

	@Override
	public @NonNull Application updateApplicationCost(long applicationId, @NonNull BigDecimal newCost) throws InvalidCostException, ApplicationNotFoundException
	{
		double doubleCost = newCost.doubleValue();
		if (doubleCost <= 0.0)
		{
			throw new InvalidCostException(doubleCost);
		}
        Optional<ApplicationJpaEntity> existingApplication = applicationJpaRepository.findById(applicationId);

        if (existingApplication.isEmpty())
        {
            throw new ApplicationNotFoundException(applicationId);
        }
        else
        {
			ApplicationJpaEntity applicationValue = existingApplication.get();
            applicationValue.setMonthlyCost(newCost);
            return applicationJpaRepository.save(applicationValue).toDomainEntity();
        }
    }

	@Override
	public @NonNull List<Subscription> getSubscriptionsForApplication(long applicationId)
	{
		return applicationJpaRepository.getSubscriptionsForApplication(applicationId);
	}

	@Override
	public @NonNull List<Application> findAll()
	{
		return applicationJpaRepository.findAll()
									   .stream()
									   .map(ApplicationJpaEntity::toDomainEntity)
									   .toList();
	}

	private final ApplicationJpaRepository applicationJpaRepository;
}
