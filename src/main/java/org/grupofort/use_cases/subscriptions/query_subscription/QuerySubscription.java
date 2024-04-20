package org.grupofort.use_cases.subscriptions.query_subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuerySubscription
{
	@Autowired
	public QuerySubscription(QuerySubscriptionsDataAccess querySubscriptionsDataAccess)
	{
		this.querySubscriptionsDataAccess = querySubscriptionsDataAccess;
	}

	private final QuerySubscriptionsDataAccess querySubscriptionsDataAccess;
}
