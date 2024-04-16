package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.entities.ApplicationJpaEntity;
import org.grupofort.subscription_server.persistence.jpa_repositories.ApplicationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "servcad/aplicativos")
public class ApplicationsController
{
	@Autowired
	public ApplicationsController(ApplicationJpaRepository applicationJpaRepository)
	{
		this.applicationJpaRepository = applicationJpaRepository;
	}

	@GetMapping()
	public List<Application> getAllApplications()
	{
		return applicationJpaRepository.findAll()
								    .stream()
								    .map(ApplicationJpaEntity::toDomainEntity)
								    .toList();
	}

	private final ApplicationJpaRepository applicationJpaRepository;
}
