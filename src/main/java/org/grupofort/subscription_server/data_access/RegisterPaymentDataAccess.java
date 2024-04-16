package org.grupofort.subscription_server.data_access;

import org.grupofort.subscription_server.persistence.exceptions.SubscriptionNotFoundException;

import java.math.BigDecimal;
import java.util.Date;

public interface RegisterPaymentDataAccess
{
    void registerPayment(Date paymentData, long subscriptionId, BigDecimal paidAmount) throws SubscriptionNotFoundException;
}
