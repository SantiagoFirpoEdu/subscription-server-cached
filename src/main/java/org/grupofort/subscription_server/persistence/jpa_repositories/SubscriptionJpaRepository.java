package org.grupofort.subscription_server.persistence.jpa_repositories;

import org.grupofort.subscription_server.persistence.entities.SubscriptionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionJpaRepository extends JpaRepository<SubscriptionJpaEntity, Long>
{
}
