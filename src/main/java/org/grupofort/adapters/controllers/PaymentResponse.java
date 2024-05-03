package org.grupofort.adapters.controllers;

public record PaymentResponse(EPaymentStatus status, double returnedValue)
{
}
