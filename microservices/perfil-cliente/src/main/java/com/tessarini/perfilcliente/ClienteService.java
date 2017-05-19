package com.tessarini.perfilcliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteService {

	ClienteRespository clienteRespository;
	Sender sender;

	@Autowired
	ClienteService(ClienteRespository customerRespository, Sender sender) {
		this.clienteRespository = customerRespository;
		this.sender = sender;
	}

	Cliente register(Cliente cliente) {
		Optional<Cliente> clienteExistente = clienteRespository.findByNome(cliente.getNome());
		if (clienteExistente.isPresent()) {
			throw new RuntimeException("cliente ja existe");
		} else {
			clienteRespository.save(cliente);
			sender.send(cliente.getEmail());
		}
		return cliente;
	}

}
