package org.grupofort.adapters.jpa.jpa_repositories;

import org.grupofort.adapters.jpa.entities.SubscriptionJpaEntity;
import org.grupofort.adapters.jpa.entities.ApplicationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationJpaRepository extends JpaRepository<ApplicationJpaEntity, Long>
{
	@Query("SELECT s FROM SubscriptionJpaEntity s WHERE s.application.id = :applicationId")
	List<SubscriptionJpaEntity> getSubscriptionsForApplication(long applicationId);
}
