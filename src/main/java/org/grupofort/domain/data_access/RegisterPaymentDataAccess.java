package org.grupofort.domain.data_access;

import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface RegisterPaymentDataAccess
{
    void registerPayment(LocalDate paymentData, long subscriptionId, BigDecimal paidAmount) throws SubscriptionNotFoundException;
}
