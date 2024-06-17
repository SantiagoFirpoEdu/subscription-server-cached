package org.grupofort.adapters.controllers.payments;

import java.time.LocalDate;

public record PaymentResponse(EPaymentStatus status, LocalDate endDate, double returnedValue)
{
}
