package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.repositories.ApplicationRepository;
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
	public ApplicationsController(ApplicationRepository applicationRepository)
	{
		this.applicationRepository = applicationRepository;
	}

	@GetMapping()
	public List<Application> getAllApplications()
	{
		return applicationRepository.findAll().;
	}

	private final ApplicationRepository applicationRepository;
}
