package org.grupofort.adapters.controllers.applications;

import org.grupofort.application.use_cases.applications.query_applications.QueryApplications;
import org.grupofort.domain.entities.Application;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.InvalidCostException;
import org.grupofort.application.use_cases.applications.manage_applications.ManageApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "servcad/aplicativos")
public class ApplicationsController
{
	@Autowired
	public ApplicationsController(QueryApplications queryApplications, ManageApplications manageApplications)
	{
		this.queryApplications = queryApplications;
		this.manageApplications = manageApplications;
	}

	@GetMapping()
	public List<Application> getAllApplications()
	{
		return queryApplications.findAll();
	}

	@PostMapping("atualizacusto/{applicationId}")
	@ResponseStatus(HttpStatus.CREATED)
	public @NonNull Application updateApplicationCost(@PathVariable long applicationId, @NonNull @RequestBody UpdateCostRequest newCost) throws InvalidCostException, ApplicationNotFoundException
	{
		return manageApplications.updateApplicationCost(applicationId, BigDecimal.valueOf(newCost.custo()));
	}

	private final QueryApplications queryApplications;
	private final ManageApplications manageApplications;
}
