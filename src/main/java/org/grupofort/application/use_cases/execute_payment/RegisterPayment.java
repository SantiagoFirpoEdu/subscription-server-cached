package org.grupofort.application.use_cases.execute_payment;

import org.grupofort.adapters.jpa.entities.SubscriptionJpaEntity;
import org.grupofort.adapters.jpa.jpa_repositories.SubscriptionJpaRepository;
import org.grupofort.domain.data_access.RegisterPaymentDataAccess;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RegisterPayment {
    @Autowired
    private RegisterPaymentDataAccess registerPaymentDataAccess;
    @Autowired
    private SubscriptionJpaRepository subscriptionJpaRepository;

    public RegisterPayment(RegisterPaymentDataAccess registerPaymentDataAccess, SubscriptionJpaRepository subscriptionJpaRepository) {
        this.registerPaymentDataAccess = registerPaymentDataAccess;
        this.subscriptionJpaRepository = subscriptionJpaRepository;
    }

    public void registerPayment(LocalDate date, long subscriptionId, BigDecimal paidAmount) throws SubscriptionNotFoundException {
        Optional<SubscriptionJpaEntity> subscriptionOpt = subscriptionJpaRepository.findById(subscriptionId);
        if (subscriptionOpt.isEmpty()) {
            throw new SubscriptionNotFoundException(subscriptionId);
        }

        SubscriptionJpaEntity subscription = subscriptionOpt.get();
        BigDecimal monthlyCost = subscription.getApplication().getMonthlyCost();

        if (paidAmount.compareTo(monthlyCost) == 0) {
            LocalDate newEndDate = calculateNewEndDate(subscription.getEndDate(), date);
            subscription.setEndDate(newEndDate);
            subscriptionJpaRepository.save(subscription);
        } else {
            throw new IllegalArgumentException("Paid amount does not match the monthly cost.");
        }

        registerPaymentDataAccess.registerPayment(date, subscriptionId, paidAmount);
    }

    private LocalDate calculateNewEndDate(LocalDate currentEndDate, LocalDate paymentDate) {
        if (currentEndDate.isBefore(paymentDate)) {
            return paymentDate.plusDays(30);
        } else {
            return currentEndDate.plusDays(30);
        }
    }
}
