package org.grupofort.adapters.repositories;

import org.grupofort.domain.data_access.RegisterPaymentDataAccess;
import org.grupofort.adapters.jpa.entities.PaymentJpaEntity;
import org.grupofort.adapters.jpa.entities.SubscriptionJpaEntity;
import org.grupofort.domain.data_access.exceptions.InvalidPaidAmountException;
import org.grupofort.adapters.jpa.jpa_repositories.PaymentJpaRepository;
import org.grupofort.domain.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class PaymentRepository implements RegisterPaymentDataAccess
{
    @Autowired
    public PaymentRepository(PaymentJpaRepository paymentJpaRepository)
    {
        this.paymentJpaRepository = paymentJpaRepository;
    }

    @Override
    public void registerPayment(LocalDate paymentDate, Subscription subscription, BigDecimal paidAmount) throws InvalidPaidAmountException
    {
        if (paidAmount.compareTo(BigDecimal.ZERO) <= 0)
        {
            throw new InvalidPaidAmountException("Paid amount must be greater than zero");
        }

        PaymentJpaEntity payment = new PaymentJpaEntity(SubscriptionJpaEntity.fromDomainEntity(subscription), paidAmount, paymentDate, "none");
        paymentJpaRepository.save(payment);
    }

    private final PaymentJpaRepository paymentJpaRepository;
}
