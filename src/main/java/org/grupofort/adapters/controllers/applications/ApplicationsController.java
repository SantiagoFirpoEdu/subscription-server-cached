package org.grupofort.adapters.controllers.applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.InvalidCostException;
import org.grupofort.application.use_cases.applications.manage_applications.ManageApplications;
import org.grupofort.domain.data_access.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
	public @NonNull Application updateApplicationCost(@PathVariable long applicationId, @NonNull @RequestBody UpdateCostRequest newCost) throws InvalidCostException, ApplicationNotFoundException
	{
		return manageApplications.updateApplicationCost(applicationId, BigDecimal.valueOf(newCost.custo()));
	}

	private final QueryApplicationsDataAccess queryApplicationsDataAccess;
	private final ManageApplications manageApplications;
}
