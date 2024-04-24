package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.Subscription;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QueryApplicationsDataAccess
{
	@NonNull
	List<Subscription> getSubscriptionsForApplication(long applicationId);
	List<Application> findAll();
}
