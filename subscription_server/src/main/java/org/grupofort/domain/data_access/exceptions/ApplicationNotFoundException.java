package org.grupofort.domain.data_access.exceptions;

public class ApplicationNotFoundException extends Exception
{
    public ApplicationNotFoundException(long applicationId)
    {
        super("Application with id %d not found".formatted(applicationId));
    }
}
