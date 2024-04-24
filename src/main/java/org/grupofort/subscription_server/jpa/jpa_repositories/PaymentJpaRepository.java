package org.grupofort.subscription_server.jpa.jpa_repositories;

import org.grupofort.subscription_server.jpa.entities.PaymentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentJpaEntity, Long>
{
}
