package org.grupofort.subscription_server.repositories;

import org.grupofort.subscription_server.persistence_entities.SubscriptionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionJpaEntity, Long>
{
}
