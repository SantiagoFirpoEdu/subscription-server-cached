package org.grupofort.domain.entities;

import java.math.BigDecimal;

public record Application
(
	long id,
	String name,
	BigDecimal monthlyCost
)
{
}
