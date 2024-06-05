package com.finanzas.cuentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.service.CuentaServicio;

@RestController
@RequestMapping("/Cuenta")
public class CuentaController {
	
	@Autowired
	private CuentaServicio cuentaServicio;
	

	
	@GetMapping("/cuentas")
	public List<Cuenta> listCuentas() {
		return cuentaServicio.listAllCounts();
	}
	
	@PostMapping("/crearCuenta")
	public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
		return  cuentaServicio.creaCuenta(cuenta);
	}
	
	@PostMapping("/ActualizarCuenta/{id}")
	 public Cuenta UpdateClient(@PathVariable long id,@RequestBody Cuenta cuenta) {
	   return cuentaServicio.updateCuenta(id,cuenta);
	  }
	

}
