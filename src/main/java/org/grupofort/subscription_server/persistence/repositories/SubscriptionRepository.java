package org.grupofort.subscription_server.persistence.repositories;

import org.grupofort.subscription_server.persistence.entities.ApplicationJpaEntity;
import org.grupofort.subscription_server.persistence.entities.CustomerJpaEntity;
import org.grupofort.subscription_server.persistence.entities.SubscriptionJpaEntity;
import org.grupofort.subscription_server.persistence.exceptions.ApplicationNotFoundException;
import org.grupofort.subscription_server.persistence.exceptions.CustomerNotFoundException;
import org.grupofort.subscription_server.persistence.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.subscription_server.persistence.jpa_repositories.CustomerJpaRepository;
import org.grupofort.subscription_server.persistence.jpa_repositories.SubscriptionJpaRepository;
import org.grupofort.use_cases.manage_subscriptions.SubscriptionDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public class SubscriptionRepository implements SubscriptionDataAccess
{
    @Autowired
    public SubscriptionRepository(SubscriptionJpaRepository subscriptionJpaRepository, CustomerJpaRepository customerJpaRepository, ApplicationJpaRepository applicationJpaRepository)
    {
        this.subscriptionJpaRepository = subscriptionJpaRepository;
        this.customerJpaRepository = customerJpaRepository;
        this.applicationJpaRepository = applicationJpaRepository;
    }

    @Override
    public boolean addSubscription(long customerId, long applicationId) throws CustomerNotFoundException, ApplicationNotFoundException
    {
        Optional<ApplicationJpaEntity> application = applicationJpaRepository.findById(applicationId);

        if (application.isEmpty())
        {
            throw new ApplicationNotFoundException(applicationId);
        }

        Optional<CustomerJpaEntity> customer = customerJpaRepository.findById(customerId);

        if (customer.isEmpty())
        {
            throw new CustomerNotFoundException(customerId);
        }

        SubscriptionJpaEntity subscription = new SubscriptionJpaEntity
        (
            application.get(),
            customer.get(),
            new Date(),
            new Date()
        );

        subscriptionJpaRepository.save(subscription);

        return true;
    }

    private final SubscriptionJpaRepository subscriptionJpaRepository;
    private final CustomerJpaRepository customerJpaRepository;
    private final ApplicationJpaRepository applicationJpaRepository;
}
