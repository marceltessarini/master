package com.tessarini.perfilcliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	Cliente register(@RequestBody Cliente cliente) {
		return clienteService.register(cliente);
	}

}
