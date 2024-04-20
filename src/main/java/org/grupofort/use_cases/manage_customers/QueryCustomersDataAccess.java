package org.grupofort.use_cases.manage_customers;

import org.grupofort.domain.entities.Customer;

import java.util.List;

public interface QueryCustomersDataAccess
{
	List<Customer> findAll();
}
