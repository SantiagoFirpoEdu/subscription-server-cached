package org.grupofort.subscription_server.persistence.jpa_repositories;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.entities.SubscriptionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionJpaRepository extends JpaRepository<SubscriptionJpaEntity, Long>
{
	@Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.id = :customerId")
	List<Subscription> getSubscriptionsForCustomer(long customerId);
}
