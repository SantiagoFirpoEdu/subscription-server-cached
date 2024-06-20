package org.grupofort.domain.data_access.exceptions;

public class CustomerNotFoundException extends Exception
{
    public CustomerNotFoundException(long customerId)
    {
        super("Customer with id %d not found".formatted(customerId));
    }
}
