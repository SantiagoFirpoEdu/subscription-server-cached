package org.grupofort.domain.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public record Payment
(
	long id,
	Subscription subscription,
	BigDecimal paidAmount,
	Date paymentDate,
	Optional<String> promotionCode
)
{
}
