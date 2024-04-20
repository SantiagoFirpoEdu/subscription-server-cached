package org.grupofort.use_cases.customers.query_customers;

import org.grupofort.domain.entities.Customer;

import java.util.List;

public interface QueryCustomersDataAccess
{
	List<Customer> findAll();
}
