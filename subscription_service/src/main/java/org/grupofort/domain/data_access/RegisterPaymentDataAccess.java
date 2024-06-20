package org.grupofort.domain.data_access;

import org.grupofort.domain.data_access.exceptions.MismatchingPaidAmountException;
import org.grupofort.domain.data_access.exceptions.InvalidPaidAmountException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.domain.entities.subscription.Subscription;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface RegisterPaymentDataAccess
{
    void registerPayment(LocalDate paymentData, Subscription subscription, BigDecimal paidAmount) throws SubscriptionNotFoundException, InvalidPaidAmountException, MismatchingPaidAmountException;
}
