package org.grupofort.adapters.jpa.jpa_repositories;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.adapters.jpa.entities.ApplicationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationJpaRepository extends JpaRepository<ApplicationJpaEntity, Long>
{
	@Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.id = :applicationId")
	List<Subscription> getSubscriptionsForApplication(long applicationId);
}
