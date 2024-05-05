package org.grupofort.application.use_cases.customers;

import org.grupofort.domain.data_access.QueryCustomersDataAccess;
import org.grupofort.domain.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryCustomers
{
	public QueryCustomers(QueryCustomersDataAccess queryCustomersDataAccess)
	{
		this.queryCustomersDataAccess = queryCustomersDataAccess;
	}

	public List<Customer> getAllCustomers()
	{
		return queryCustomersDataAccess.findAll();
	}

	private final QueryCustomersDataAccess queryCustomersDataAccess;
}
