package org.grupofort.adapters.repositories;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.adapters.jpa.entities.ApplicationJpaEntity;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.adapters.jpa.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.domain.data_access.exceptions.InvalidCostException;
import org.grupofort.domain.data_access.ManageApplicationsDataAccess;
import org.grupofort.domain.data_access.QueryApplicationsDataAccess;
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
