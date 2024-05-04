package org.grupofort.application.use_cases.subscriptions.manage_subscriptions;

import org.grupofort.domain.entities.Subscription;
import org.grupofort.adapters.jpa.entities.ApplicationJpaEntity;
import org.grupofort.adapters.jpa.entities.CustomerJpaEntity;
import org.grupofort.adapters.jpa.entities.SubscriptionJpaEntity;
import org.grupofort.adapters.jpa.jpa_repositories.ApplicationJpaRepository;
import org.grupofort.adapters.jpa.jpa_repositories.CustomerJpaRepository;
import org.grupofort.adapters.jpa.jpa_repositories.SubscriptionJpaRepository;
import org.grupofort.domain.data_access.AddSubscriptionDataAccess;
import org.grupofort.domain.data_access.UpdateSubscriptionDataAccess;
import org.grupofort.domain.data_access.exceptions.ApplicationNotFoundException;
import org.grupofort.domain.data_access.exceptions.CustomerNotFoundException;
import org.grupofort.domain.data_access.exceptions.SubscriptionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class SubscriptionManagement {
    @Autowired
    private ApplicationJpaRepository applicationJpaRepository;
    @Autowired
    private CustomerJpaRepository customerJpaRepository;
    @Autowired
    private SubscriptionJpaRepository subscriptionJpaRepository;

    private final AddSubscriptionDataAccess subscriptionDataAccess;
    private final UpdateSubscriptionDataAccess updateSubscriptionDataAccess;

    @Autowired
    public SubscriptionManagement(AddSubscriptionDataAccess subscriptionDataAccess, UpdateSubscriptionDataAccess updateSubscriptionDataAccess) {
        this.subscriptionDataAccess = subscriptionDataAccess;
        this.updateSubscriptionDataAccess = updateSubscriptionDataAccess;
    }

    public Subscription addSubscription(long customerId, long applicationId) throws ApplicationNotFoundException, CustomerNotFoundException {
        Optional<ApplicationJpaEntity> application = applicationJpaRepository.findById(applicationId);
        if (application.isEmpty()) {
            throw new ApplicationNotFoundException(applicationId);
        }
        Optional<CustomerJpaEntity> customer = customerJpaRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException(customerId);
        }
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);
        SubscriptionJpaEntity subscription = new SubscriptionJpaEntity(application.get(), customer.get(), startDate, endDate);
        return subscriptionJpaRepository.save(subscription).toDomainEntity();
    }

    public void updateSubscriptionEndDate(long subscriptionId, LocalDate newEndDate) throws SubscriptionNotFoundException {
        Optional<SubscriptionJpaEntity> subscription = subscriptionJpaRepository.findById(subscriptionId);
        if (subscription.isEmpty()) {
            throw new SubscriptionNotFoundException(subscriptionId);
        }
        subscription.get().setEndDate(newEndDate);
        subscriptionJpaRepository.save(subscription.get());
    }
}
