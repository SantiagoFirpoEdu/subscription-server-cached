package org.grupofort.adapters.controllers.payments;

public record RegisterPaymentRequest(
        int dia,
        int mes ,
        int ano,
        long codass,
        double valorPago
)
{

}
