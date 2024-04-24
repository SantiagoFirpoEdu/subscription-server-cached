package org.grupofort.adapters.repositories;

import org.grupofort.domain.entities.Customer;
import org.grupofort.adapters.jpa.entities.CustomerJpaEntity;
import org.grupofort.adapters.jpa.jpa_repositories.CustomerJpaRepository;
import org.grupofort.domain.data_access.QueryCustomersDataAccess;
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
