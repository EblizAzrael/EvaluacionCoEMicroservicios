package com.aguadarramal.apirest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aguadarramal.apirest.entity.Clientes;

@Component
public class ClientesImpl implements IClientesService {

	private static Map<Long,Clientes> clientes = new HashMap<>();
	private static Long index = 2L;
	
	static {
		Clientes cliente1 = new Clientes(1L, "Angel", "angel.guadarrama@gmail.com");
		Clientes cliente2 = new Clientes(2L, "Ivan", "angel.guadarrama@hotmail.com");
		clientes.put(1L, cliente1);
		clientes.put(2L, cliente2);
	}
	
	@Override
	public List<Clientes> getAllClientes() {
		return new ArrayList<>(clientes.values());
	}

	@Override
	public Clientes getClienteDetails(long ClienteId) {
		return clientes.get(ClienteId);
	}

	@Override
	public Clientes addCliente(Clientes cliente) {
		index +=1;
		cliente.setId(index);
		clientes.put(index, cliente);
		return cliente;
	}

	@Override
	public Clientes deleteClientes(Long clienteId) {
		return clientes.remove(clienteId);
	}

	@Override
	public Clientes updateCliente(long id, Clientes cliente) {
		cliente.setId(id);
		clientes.put(id, cliente);
		return cliente;
	}
	

}
