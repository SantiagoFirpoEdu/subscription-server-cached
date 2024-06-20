package org.grupofort.adapters.controllers;

import org.grupofort.application.use_cases.customers.QueryCustomers;
import org.grupofort.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "servcad/clientes")
public class CustomerController
{
	@Autowired
	public CustomerController(QueryCustomers queryCustomers)
	{
		this.queryCustomers = queryCustomers;
	}

	@GetMapping()
	public List<Customer> getAllCustomers()
	{
		return queryCustomers.getAllCustomers();
	}

	private final QueryCustomers queryCustomers;
}
