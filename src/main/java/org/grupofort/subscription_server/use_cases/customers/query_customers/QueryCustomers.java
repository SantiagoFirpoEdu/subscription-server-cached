package org.grupofort.subscription_server.use_cases.customers.query_customers;

import org.grupofort.domain.data_access.QueryCustomersDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryCustomers
{
	@Autowired
	public QueryCustomers(QueryCustomersDataAccess customerDataAccess)
	{
		this.customerDataAccess = customerDataAccess;
	}

	private final QueryCustomersDataAccess customerDataAccess;
}
