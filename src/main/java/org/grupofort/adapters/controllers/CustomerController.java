package org.grupofort.adapters.controllers;

import org.grupofort.domain.entities.Customer;
import org.grupofort.domain.data_access.QueryCustomersDataAccess;
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
	public CustomerController(QueryCustomersDataAccess customerDataAccess)
	{
		this.customerDataAccess = customerDataAccess;
	}

	@GetMapping()
	public List<Customer> getAllCustomers()
	{
		return customerDataAccess.findAll();
	}

	private final QueryCustomersDataAccess customerDataAccess;
}