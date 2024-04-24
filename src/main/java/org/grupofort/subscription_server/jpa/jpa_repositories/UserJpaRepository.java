package org.grupofort.subscription_server.jpa.jpa_repositories;

import org.grupofort.subscription_server.jpa.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long>
{
}
