package com.finanzas.cuentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.cuentas.entiti.Transaccion;
import com.finanzas.cuentas.service.TransaccionServicio;

@RestController
@RequestMapping("/transaccion")
public class TransactionController {
	
	@Autowired
	private TransaccionServicio transaccionServicio;
	
	@GetMapping("/Transacciones")
	public List<Transaccion> ListarTransaccion() {
		return transaccionServicio.listarAllCtransacciones();
	}
	
	@PostMapping("/CrearTransacciones")
	public Transaccion crearTransaccion(@RequestBody Transaccion transaccion){				
		return transaccionServicio.crearTransaccion(transaccion);
		
	}

}
