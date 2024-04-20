package org.grupofort.subscription_server.persistence.repositories;

import org.grupofort.domain.entities.Customer;
import org.grupofort.subscription_server.persistence.entities.CustomerJpaEntity;
import org.grupofort.subscription_server.persistence.jpa_repositories.CustomerJpaRepository;
import org.grupofort.use_cases.manage_customers.QueryCustomersDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepository implements QueryCustomersDataAccess
{
	@Autowired
	public CustomerRepository(CustomerJpaRepository customerJpaRepository)
	{
		this.customerJpaRepository = customerJpaRepository;
	}

	@Override
	public List<Customer> findAll()
	{
		return customerJpaRepository.findAll()
								    .stream()
								    .map(CustomerJpaEntity::toDomainEntity)
								    .toList();
	}

	private final CustomerJpaRepository customerJpaRepository;
}
