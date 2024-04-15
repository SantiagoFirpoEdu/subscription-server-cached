package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Customer;
import org.grupofort.subscription_server.persistence.entities.CustomerJpaEntity;
import org.grupofort.subscription_server.persistence.repositories.CustomerRepository;
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
	public CustomerController(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}

	@GetMapping()
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll().stream().map(CustomerJpaEntity::toDomainEntity).toList();
	}

	private final CustomerRepository customerRepository;
}
