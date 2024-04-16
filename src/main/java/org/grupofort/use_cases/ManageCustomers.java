package org.grupofort.use_cases;

import org.grupofort.subscription_server.persistence.jpa_repositories.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageCustomers
{
	@Autowired
	public ManageCustomers(CustomerJpaRepository customerJpaRepository)
	{
		this.customerJpaRepository = customerJpaRepository;
	}

	private final CustomerJpaRepository customerJpaRepository;
}
