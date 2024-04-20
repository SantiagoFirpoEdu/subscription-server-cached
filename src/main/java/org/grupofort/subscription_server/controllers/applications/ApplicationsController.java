package org.grupofort.subscription_server.controllers.applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.subscription_server.persistence.jpa_repositories.InvalidCostException;
import org.grupofort.use_cases.applications.manage_applications.ManageApplications;
import org.grupofort.use_cases.applications.query_applications.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
	public @NonNull Application updateApplicationCost(@PathVariable long applicationId, @NonNull @RequestBody UpdateCostRequest newCost) throws InvalidCostException
	{
		return manageApplications.updateApplicationCost(applicationId, newCost.custo());
	}

	private final QueryApplicationsDataAccess queryApplicationsDataAccess;
	private final ManageApplications manageApplications;
}
