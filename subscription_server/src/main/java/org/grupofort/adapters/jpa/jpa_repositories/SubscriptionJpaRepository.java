package org.grupofort.adapters.jpa.jpa_repositories;

import org.grupofort.adapters.jpa.entities.SubscriptionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionJpaRepository extends JpaRepository<SubscriptionJpaEntity, Long>
{
	@Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.customer.id = :customerId")
	List<SubscriptionJpaEntity> getSubscriptionsForCustomer(long customerId);

	@Query("SELECT s FROM SubscriptionJpaEntity s " +
	       "WHERE s.endDate >= CURRENT_DATE AND s.startDate <= CURRENT_DATE AND :statusFilter = 'ACTIVE' " +
	       "OR s.endDate < CURRENT_DATE AND :statusFilter = 'CANCELLED' " +
	       "OR :statusFilter = 'ALL'")
	List<SubscriptionJpaEntity> querySubscriptions(String statusFilter);
}
