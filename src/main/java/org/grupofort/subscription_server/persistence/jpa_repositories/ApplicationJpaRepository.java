package org.grupofort.subscription_server.persistence.jpa_repositories;

import org.grupofort.domain.entities.Application;
import org.grupofort.domain.entities.Subscription;
import org.grupofort.subscription_server.persistence.entities.ApplicationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationJpaRepository extends JpaRepository<ApplicationJpaEntity, Long>
{
	@Query("UPDATE ApplicationJpaEntity a SET a.monthlyCost = :newCost WHERE a.id = :applicationId")
	@Modifying()
	Application updateApplicationCost(long applicationId, double newCost);

	@Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.id = :applicationId")
	List<Subscription> getSubscriptionsForApplication(long applicationId);
}
