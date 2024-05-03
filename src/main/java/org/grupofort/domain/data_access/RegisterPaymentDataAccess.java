package org.grupofort.domain.data_access;

import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.domain.entities.Subscription;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface RegisterPaymentDataAccess
{
    void registerPayment(LocalDate paymentData, Subscription subscription, BigDecimal paidAmount) throws SubscriptionNotFoundException;
}
