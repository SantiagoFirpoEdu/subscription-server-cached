package org.grupofort.adapters.controllers.applications;

import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.application.use_cases.applications.query_applications.QueryApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "servcad/assapp")
public class ApplicationsSubscriptionsController
{
	@Autowired
	public ApplicationsSubscriptionsController(QueryApplications queryApplications)
	{
		this.queryApplications = queryApplications;
	}

	@GetMapping("/{applicationId}")
	List<Subscription> getSubscriptionsForApplication(@PathVariable long applicationId)
	{
		return queryApplications.getSubscriptionsForApplication(applicationId);
	}

	private final QueryApplications queryApplications;
}
