package com.finanzas.cuentas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.cuentas.entiti.Cliente;
import com.finanzas.cuentas.repository.ClienteRepository;

@Service
public class CuentasServiciosImp implements ClienteServicio{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente ListarCliente(long id) {
		Cliente clienteExistente = clienteRepository.findById(id).get();
		
	   return clienteExistente;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	
	
	
	


}
