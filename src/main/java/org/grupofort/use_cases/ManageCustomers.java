package org.grupofort.use_cases;

import org.grupofort.subscription_server.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageCustomers
{
	@Autowired
	public ManageCustomers(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}

	private CustomerRepository customerRepository;
}
