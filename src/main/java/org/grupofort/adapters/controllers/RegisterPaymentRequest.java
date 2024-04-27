package org.grupofort.adapters.controllers;

public record RegisterPaymentRequest(
        int dia,
        int mes ,
        int ano,
        long codass,
        double valorPago
)
{

}
