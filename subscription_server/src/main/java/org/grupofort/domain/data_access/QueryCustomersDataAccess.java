package org.grupofort.domain.data_access;

import org.grupofort.domain.entities.Customer;

import java.util.List;

public interface QueryCustomersDataAccess
{
	List<Customer> findAll();
}
