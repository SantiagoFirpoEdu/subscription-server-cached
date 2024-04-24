package org.grupofort.adapters.jpa.jpa_repositories;

import org.grupofort.adapters.jpa.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long>
{
}
