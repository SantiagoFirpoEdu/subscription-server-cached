package org.grupofort.adapters.jpa.jpa_repositories;

import org.grupofort.adapters.jpa.entities.PaymentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentJpaEntity, Long>
{
}
