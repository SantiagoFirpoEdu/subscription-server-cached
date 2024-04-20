package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Application;
import org.grupofort.use_cases.applications.manage_applications.ManageApplications;
import org.grupofort.use_cases.applications.query_applications.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "servcad/aplicativos")
public class ApplicationsController
{
	@Autowired
	public ApplicationsController(QueryApplicationsDataAccess queryApplicationsDataAccess, ManageApplications manageApplications)
	{
		this.queryApplicationsDataAccess = queryApplicationsDataAccess;
		this.manageApplications = manageApplications;
	}

	@GetMapping()
	public List<Application> getAllApplications()
	{
		return queryApplicationsDataAccess.findAll();
	}

	@PostMapping("atualizacusto/{applicationId}")
	public Application updateApplicationCost(@PathVariable long applicationId, double newCost)
	{
		return manageApplications.updateApplicationCost(applicationId, newCost);
	}

	private final QueryApplicationsDataAccess queryApplicationsDataAccess;
	private final ManageApplications manageApplications;
}
