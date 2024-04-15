package org.grupofort.subscription_server.repositories;

import org.grupofort.subscription_server.persistence_entities.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerJpaEntity, Long>
{
}
