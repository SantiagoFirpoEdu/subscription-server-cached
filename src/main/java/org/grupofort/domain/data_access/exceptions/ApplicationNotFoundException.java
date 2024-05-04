package org.grupofort.domain.data_access.exceptions;

public class ApplicationNotFoundException extends Throwable
{
    public ApplicationNotFoundException(long applicationId)
    {
    }
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}
