package org.grupofort.subscription_server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController
{
	@GetMapping(path = "servcad/clientes")
	public void getCustomers()
	{
	}
}
