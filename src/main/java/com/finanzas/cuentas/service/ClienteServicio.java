package com.finanzas.cuentas.service;

import java.text.ParseException;
import java.util.List;


import com.finanzas.cuentas.entiti.Cliente;

public interface ClienteServicio {

	public List<Cliente> listarAllClientes();
	
	public Cliente createCliente(Cliente cliente) throws ParseException;
	
	public Cliente ListarCliente(long id);
	
	public Cliente updateCliente(Cliente cliente);
	
	public void deletCliente(long id);
	
}
