package org.grupofort.subscription_server.jpa.jpa_repositories;

import org.grupofort.subscription_server.jpa.entities.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long>
{
}
