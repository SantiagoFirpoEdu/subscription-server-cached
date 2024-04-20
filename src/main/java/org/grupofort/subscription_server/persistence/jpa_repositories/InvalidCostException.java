package org.grupofort.subscription_server.persistence.jpa_repositories;

public class InvalidCostException extends Exception
{
    public InvalidCostException(double invalidCost)
    {
        super("Invalid cost: %s".formatted(invalidCost));
    }
}
