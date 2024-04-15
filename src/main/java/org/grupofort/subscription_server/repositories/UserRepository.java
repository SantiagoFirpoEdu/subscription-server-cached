package org.grupofort.subscription_server.repositories;

import org.grupofort.subscription_server.persistence_entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpaEntity, Long>
{
}
