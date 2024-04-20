package org.grupofort.use_cases.customers.query_customers;

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
