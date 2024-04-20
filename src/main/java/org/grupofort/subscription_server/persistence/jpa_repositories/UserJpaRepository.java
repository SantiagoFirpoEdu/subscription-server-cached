package org.grupofort.subscription_server.persistence.jpa_repositories;

import jakarta.persistence.Table;
import org.grupofort.subscription_server.persistence.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long>
{
}
