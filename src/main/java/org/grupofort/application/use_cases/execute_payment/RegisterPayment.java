package org.grupofort.application.use_cases.execute_payment;

import org.grupofort.domain.data_access.exceptions.MismatchingPaidAmountException;
import org.grupofort.domain.data_access.subscriptions.QuerySubscriptionsDataAccess;
import org.grupofort.domain.data_access.RegisterPaymentDataAccess;
import org.grupofort.domain.data_access.UpdateSubscriptionDataAccess;
import org.grupofort.domain.data_access.exceptions.InvalidPaidAmountException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.domain.entities.subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class RegisterPayment
{
	@Autowired
	public RegisterPayment(RegisterPaymentDataAccess registerPaymentDataAccess, UpdateSubscriptionDataAccess updateSubscriptionDataAccess, QuerySubscriptionsDataAccess querySubscriptionsDataAccess)
	{
        this.registerPaymentDataAccess = registerPaymentDataAccess;
		this.updateSubscriptionDataAccess = updateSubscriptionDataAccess;
		this.querySubscriptionsDataAccess = querySubscriptionsDataAccess;
	}

	public @NonNull LocalDate registerPayment(LocalDate date, long subscriptionId, @NonNull BigDecimal paidAmount) throws SubscriptionNotFoundException, InvalidPaidAmountException, MismatchingPaidAmountException
	{
		Optional<Subscription> foundSubscription = querySubscriptionsDataAccess.findById(subscriptionId);

		if (foundSubscription.isEmpty())
        {
            throw new SubscriptionNotFoundException(subscriptionId);
        }

		Subscription subscription = foundSubscription.get();

		if (paidAmount.compareTo(BigDecimal.ZERO) <= 0)
		{
			throw new InvalidPaidAmountException(paidAmount.doubleValue());
		}

		BigDecimal applicationMonthlyCost = subscription.application().monthlyCost();
		if (paidAmount.compareTo(applicationMonthlyCost) != 0)
		{
			throw new MismatchingPaidAmountException(paidAmount.doubleValue(), applicationMonthlyCost.doubleValue());
		}

		registerPaymentDataAccess.registerPayment(date, subscription, paidAmount);

		LocalDate dateToUse = subscription.endDate().isAfter(date) ? subscription.endDate() : date;
		LocalDate newEndDate = dateToUse.plusMonths(1);
		updateSubscriptionDataAccess.updateSubscriptionEndDate(subscriptionId, newEndDate);

		return newEndDate;
	}

	private final RegisterPaymentDataAccess registerPaymentDataAccess;
	private final UpdateSubscriptionDataAccess updateSubscriptionDataAccess;
	private final QuerySubscriptionsDataAccess querySubscriptionsDataAccess;
}
