package org.grupofort.use_cases.execute_payment;

import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface RegisterPaymentDataAccess
{
    void registerPayment(LocalDate paymentData, long subscriptionId, BigDecimal paidAmount) throws SubscriptionNotFoundException;
}
