package org.grupofort.use_cases.applications.manage_applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageCustomers
{
	@Autowired
	public ManageCustomers(CustomerDataAccess customerDataAccess)
	{
		this.customerDataAccess = customerDataAccess;
	}

	private final CustomerDataAccess customerDataAccess;
}
