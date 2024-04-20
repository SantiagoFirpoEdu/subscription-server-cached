package org.grupofort.subscription_server.persistence.jpa_repositories;

import jakarta.persistence.Table;
import org.grupofort.subscription_server.persistence.entities.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long>
{
}
