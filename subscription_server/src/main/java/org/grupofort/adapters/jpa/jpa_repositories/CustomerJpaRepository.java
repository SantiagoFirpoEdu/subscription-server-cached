package org.grupofort.adapters.jpa.jpa_repositories;

import org.grupofort.adapters.jpa.entities.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long>
{
}
