package org.grupofort.subscription_server.controllers;

import org.grupofort.domain.entities.Customer;
import org.grupofort.subscription_server.persistence.entities.CustomerJpaEntity;
import org.grupofort.subscription_server.persistence.jpa_repositories.CustomerJpaRepository;
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
	public CustomerController(CustomerJpaRepository customerJpaRepository)
	{
		this.customerJpaRepository = customerJpaRepository;
	}

	@GetMapping()
	public List<Customer> getAllCustomers()
	{
		return customerJpaRepository.findAll()
							     .stream()
							     .map(CustomerJpaEntity::toDomainEntity)
							     .toList();
	}

	private final CustomerJpaRepository customerJpaRepository;
}
