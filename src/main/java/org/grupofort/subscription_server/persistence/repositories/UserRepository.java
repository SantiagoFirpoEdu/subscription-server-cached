package org.grupofort.subscription_server.persistence.repositories;

import org.grupofort.subscription_server.persistence.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpaEntity, Long>
{
}
