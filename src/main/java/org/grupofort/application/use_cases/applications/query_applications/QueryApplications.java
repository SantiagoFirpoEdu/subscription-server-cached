package org.grupofort.application.use_cases.applications.query_applications;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.domain.data_access.QueryApplicationsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Subscription> getSubscriptionsForApplication(long applicationId)
	{
		return queryApplicationsDataAccess.getSubscriptionsForApplication(applicationId);
	}

	private final QueryApplicationsDataAccess queryApplicationsDataAccess;
}
