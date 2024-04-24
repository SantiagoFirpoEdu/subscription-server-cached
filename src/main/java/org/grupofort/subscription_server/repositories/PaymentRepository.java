package org.grupofort.subscription_server.repositories;

import org.grupofort.domain.data_access.RegisterPaymentDataAccess;
import org.grupofort.subscription_server.jpa.entities.PaymentJpaEntity;
import org.grupofort.subscription_server.jpa.entities.SubscriptionJpaEntity;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.subscription_server.jpa.jpa_repositories.PaymentJpaRepository;
import org.grupofort.subscription_server.jpa.jpa_repositories.SubscriptionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class PaymentRepository implements RegisterPaymentDataAccess
{
    @Autowired
    public PaymentRepository(PaymentJpaRepository paymentJpaRepository, SubscriptionJpaRepository subscriptionJpaRepository)
    {
        this.paymentJpaRepository = paymentJpaRepository;
        this.subscriptionJpaRepository = subscriptionJpaRepository;
    }

    @Override
    public void registerPayment(LocalDate paymentDate, long subscriptionId, BigDecimal paidAmount) throws SubscriptionNotFoundException
    {
        Optional<SubscriptionJpaEntity> subscription = subscriptionJpaRepository.findById(subscriptionId);

        if (subscription.isEmpty())
        {
            throw new SubscriptionNotFoundException(subscriptionId);
        }

        PaymentJpaEntity payment = new PaymentJpaEntity(subscription.get(), paidAmount, paymentDate, "none");
        paymentJpaRepository.save(payment);
    }

    private final PaymentJpaRepository paymentJpaRepository;
    private final SubscriptionJpaRepository subscriptionJpaRepository;
}
