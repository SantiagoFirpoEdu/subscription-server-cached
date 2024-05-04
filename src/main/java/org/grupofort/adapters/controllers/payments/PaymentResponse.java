package org.grupofort.adapters.controllers.payments;

public record PaymentResponse(EPaymentStatus status, double returnedValue)
{
}
