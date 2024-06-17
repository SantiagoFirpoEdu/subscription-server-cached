package org.grupofort.application.use_cases.applications.query_applications;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.subscription.Subscription;
import org.grupofort.domain.data_access.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryApplications
{
	@Autowired
	public QueryApplications(QueryApplicationsDataAccess queryApplicationsDataAccess)
	{
		this.queryApplicationsDataAccess = queryApplicationsDataAccess;
	}

	public @NonNull List<Subscription> getSubscriptionsForApplication(long applicationId)
	{
		return queryApplicationsDataAccess.getSubscriptionsForApplication(applicationId);
	}

	public List<Application> findAll()
	{
		return queryApplicationsDataAccess.findAll();
	}

	private final QueryApplicationsDataAccess queryApplicationsDataAccess;
}
