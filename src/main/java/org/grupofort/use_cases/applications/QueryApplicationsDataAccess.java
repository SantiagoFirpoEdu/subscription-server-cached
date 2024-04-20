package org.grupofort.use_cases.applications;

import org.grupofort.domain.entities.Subscription;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QueryApplicationsDataAccess
{
	List<Subscription> getSubscriptionsForApplication(long applicationId);
}
