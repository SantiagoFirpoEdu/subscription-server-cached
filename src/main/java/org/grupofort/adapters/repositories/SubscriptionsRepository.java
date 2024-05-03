package org.grupofort.adapters.repositories;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.adapters.jpa.entities.ApplicationJpaEntity;
import org.grupofort.adapters.jpa.entities.CustomerJpaEntity;
import org.grupofort.adapters.jpa.entities.SubscriptionJpaEntity;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.grupofort.adapters.jpa.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.adapters.jpa.jpa_repositories.CustomerJpaRepository;
import org.grupofort.adapters.jpa.jpa_repositories.SubscriptionJpaRepository;
import org.grupofort.domain.data_access.AddSubscriptionDataAccess;
import org.grupofort.domain.data_access.UpdateSubscriptionDataAccess;
import org.grupofort.application.use_cases.subscriptions.query_subscription.ESubscriptionStatusFilter;
import org.grupofort.domain.data_access.QuerySubscriptionsDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class SubscriptionsRepository implements AddSubscriptionDataAccess, QuerySubscriptionsDataAccess, UpdateSubscriptionDataAccess
{
    @Autowired
    public SubscriptionsRepository(SubscriptionJpaRepository subscriptionJpaRepository, CustomerJpaRepository customerJpaRepository, ApplicationJpaRepository applicationJpaRepository)
    {
        this.subscriptionJpaRepository = subscriptionJpaRepository;
        this.customerJpaRepository = customerJpaRepository;
        this.applicationJpaRepository = applicationJpaRepository;
    }

    @Override
    public Subscription addSubscription(long customerId, long applicationId) throws CustomerNotFoundException, ApplicationNotFoundException
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
            LocalDate.now(),
            LocalDate.now().plusDays(7)
        );

        return subscriptionJpaRepository.save(subscription).toDomainEntity();
    }

    @Override
    public List<Subscription> querySubscriptions(ESubscriptionStatusFilter statusFilter)
    {
        return subscriptionJpaRepository.querySubscriptions(statusFilter.toString())
                                        .stream()
                                        .map(SubscriptionJpaEntity::toDomainEntity)
                                        .toList();
    }

    @Override
    public List<Subscription> getSubscriptionsForCustomer(long customerId)
    {
        return subscriptionJpaRepository.getSubscriptionsForCustomer(customerId)
                                        .stream()
                                        .map(SubscriptionJpaEntity::toDomainEntity)
                                        .toList();
    }

    @Override
    public boolean isSubscriptionActive(long subscriptionId) throws SubscriptionNotFoundException
    {
	    Optional<SubscriptionJpaEntity> found = subscriptionJpaRepository.findById(subscriptionId);
        if (found.isEmpty())
        {
            throw new SubscriptionNotFoundException(subscriptionId);
        }

        return found.get().toDomainEntity().endDate().isAfter(LocalDate.now());
    }

    @Override
    public List<Subscription> findAll()
    {
        return subscriptionJpaRepository.findAll()
                                        .stream()
                                        .map(SubscriptionJpaEntity::toDomainEntity)
                                        .toList();
    }

    @Override
    public Optional<Subscription> findById(long subscriptionId)
    {
        return subscriptionJpaRepository.findById(subscriptionId).map(SubscriptionJpaEntity::toDomainEntity);
    }

    private final SubscriptionJpaRepository subscriptionJpaRepository;
    private final CustomerJpaRepository customerJpaRepository;
    private final ApplicationJpaRepository applicationJpaRepository;

    @Override
    public Subscription updateSubscriptionEndDate(long subscriptionId, LocalDate newEndDate) throws SubscriptionNotFoundException
    {
        Optional<SubscriptionJpaEntity> existingSubscription = subscriptionJpaRepository.findById(subscriptionId);
        if (existingSubscription.isEmpty())
        {
            throw new SubscriptionNotFoundException(subscriptionId);
        }

        SubscriptionJpaEntity subscription = existingSubscription.get();
        subscription.setEndDate(newEndDate);
        return subscriptionJpaRepository.save(subscription).toDomainEntity();
    }
}
