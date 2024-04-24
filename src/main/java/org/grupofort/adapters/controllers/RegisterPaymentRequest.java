package org.grupofort.adapters.controllers;

import java.math.BigDecimal;

public record RegisterPaymentRequest(
        int dia,
        int mes ,
        int ano,
        long codass,
        BigDecimal valorPago
)
{

}
