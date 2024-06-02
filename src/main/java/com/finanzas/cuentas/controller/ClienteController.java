package com.finanzas.cuentas.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.cuentas.entiti.Cliente;
import com.finanzas.cuentas.service.ClienteServicio;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServicio clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> ListarClientes() {
		return clienteService.listarAllClientes();
	}
	
	@PostMapping("/crearCliente")
	 public Cliente createClient(@RequestBody Cliente cliente) {
	   return clienteService.createCliente(cliente);
	  }
	
	@PostMapping("/ActualizarCliente/{id}")
	 public Cliente UpdateClient(@PathVariable long id,@RequestBody Cliente cliente) {
		Cliente clienteExistente = clienteService.ListarCliente(id);
		LocalDateTime ahora = LocalDateTime.now();
		clienteExistente.setCorreo(cliente.getCorreo());
		clienteExistente.setFechModificación(ahora);
	   return clienteService.updateCliente(clienteExistente);
	  }
	
	@PostMapping("/EliminarCliente/{id}")
	 public void DeleteClient(@PathVariable long id) {
	    clienteService.deletCliente(id);
	  }
}
