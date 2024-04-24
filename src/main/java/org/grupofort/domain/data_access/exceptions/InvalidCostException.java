package org.grupofort.domain.data_access.exceptions;

public class InvalidCostException extends Exception
{
    public InvalidCostException(double invalidCost)
    {
        super("Invalid cost: %s".formatted(invalidCost));
    }
}
