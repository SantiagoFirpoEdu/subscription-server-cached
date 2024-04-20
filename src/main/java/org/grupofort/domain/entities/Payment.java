package org.grupofort.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public record Payment
(
	long id,
	Subscription subscription,
	BigDecimal paidAmount,
	LocalDate paymentDate,
	Optional<String> promotionCode
)
{
}
