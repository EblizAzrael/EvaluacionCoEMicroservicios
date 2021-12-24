package com.aguadarramal.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aguadarramal.apirest.entity.Clientes;

@Service
public interface IClientesService {

	List<Clientes> getAllClientes();
	
	Clientes getClienteDetails(long ClienteId); 
	
	Clientes addCliente(Clientes cliente); 
	
	Clientes deleteClientes(Long clienteId); 
	
	Clientes updateCliente(long id, Clientes cliente);
}
