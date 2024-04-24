package org.grupofort.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.grupofort")
public class SubscriberAuthenticatorApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SubscriberAuthenticatorApplication.class, args);
	}
}
