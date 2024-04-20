package org.grupofort.subscription_server.persistence.repositories;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.entities.ApplicationJpaEntity;
import org.grupofort.subscription_server.persistence.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.use_cases.applications.manage_applications.ManageApplicationsDataAccess;
import org.grupofort.use_cases.applications.query_applications.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationRepository implements ManageApplicationsDataAccess, QueryApplicationsDataAccess
{
	@Autowired
	public ApplicationRepository(ApplicationJpaRepository applicationJpaRepository)
	{
		this.applicationJpaRepository = applicationJpaRepository;
	}

	@Override
	public Application updateApplicationCost(long applicationId, double newCost)
	{
		return applicationJpaRepository.updateApplicationCost(applicationId, newCost);
	}

	@Override
	public List<Subscription> getSubscriptionsForApplication(long applicationId)
	{
		return applicationJpaRepository.getSubscriptionsForApplication(applicationId);
	}

	@Override
	public List<Application> findAll()
	{
		return applicationJpaRepository.findAll()
									   .stream()
									   .map(ApplicationJpaEntity::toDomainEntity)
									   .toList();
	}

	private final ApplicationJpaRepository applicationJpaRepository;
}
