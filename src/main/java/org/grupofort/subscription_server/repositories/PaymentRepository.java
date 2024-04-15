package org.grupofort.subscription_server.repositories;

import org.grupofort.domain.entities.Payment;
import org.grupofort.subscription_server.persistence_entities.PaymentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentJpaEntity, Long>
{
}
